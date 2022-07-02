package hexlet.code;

import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestIsValidIsMapSchema {

    @Test
    public void schemaTestRequired() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();

        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid("Map")).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();
    }

    @Test
    public void schemaTestSizeOf() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        schema.required();
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();
        assertThat(schema.sizeof(2).isValid(data)).isFalse();
        data.put("key2", "value2");
        assertThat(schema.sizeof(2).isValid(data)).isTrue();
        data.put("key3", "value3");
        assertThat(schema.sizeof(2).isValid(data)).isFalse();
        data.clear();
        schema.clean();
        assertThat(schema.sizeof(0).isValid(data)).isTrue();

    }
}
