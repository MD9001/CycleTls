package kvant.cycletls.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JacksonApi {
    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    @SneakyThrows
    public byte[] writeAsBytes(Object any) {
        return OBJECT_MAPPER.writeValueAsBytes(any);
    }

    @SneakyThrows
    public <T> T readFromBytes(byte[] bytes, Class<T> clazz) {
        return OBJECT_MAPPER.readValue(bytes, clazz);
    }

    public <T> T convertToValue(Object any, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(any, clazz);
    }

    public ObjectNode newObjectNode() {
        return OBJECT_MAPPER.createObjectNode();
    }

    public ArrayNode newArrayNode() {
        return OBJECT_MAPPER.createArrayNode();
    }
}
