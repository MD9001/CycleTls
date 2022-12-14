# CycleTls - Java
Simple project providing CycleTLS project bindings
for java, including Browser data generation, System platform emulation and user agent generation with according JA3 fingerprint.

More info about JA3: https://github.com/salesforce/ja3

More info about CycleTls: https://github.com/Danny-Dasilva/CycleTLS

# Usage
Launch the instance of CycleTls manually or from code invoking
```java
Path path = Paths.get("path/to/cycletls/binary");
Process process = CycleTls.launch(path);
```
Then create channel and connect to the address of CycleTLS socket server

For async channel use

```java
AsyncTlsChannel channel = CycleTls.createAsyncChannel();
```

or for sync one:
```java
TlsChannel channel = CycleTls.createChannel();
```
and simply connect to socket address of launched CycleTLS

```java
channel.connect("127.0.0.1", 8080); //default host and port of CycleTLS socket server
```
# Creating request
Use TlsRequestBuilder to easily create a request.
```java
Browser browser = new ChromeBrowser();

UserAgent ua = browser.generateUserAgent();
String ja3FingerPrint = browser.getFingerprint(ua); //your ja3 fingerprint
        
TlsRequest request = TlsRequest.newBuilder("url", "METHOD", ja3FingerPrint)
        .requestId("youRequestId") //you need to know your request id in async environment
        .proxy("host:port") //proxy to use
        .userAgent(ua.toString()) //user agent
        .body("") //Body, if it is POST or PUT requests
        ..... //see TlsRequestBuilder.class for all params
        .build();

TlsResponse response = channel.send(request); //or sendAsync if you used AsyncTlsChannel
//Or for AsyncTlsChannel
CompletableFuture<TlsResponse> futureResponse = channel.sendAsync(request);
```