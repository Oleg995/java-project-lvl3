package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TestIsValidIsMapSchema {
    private static final Integer NUMBER_AGE = 100;

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

    @Test
    public void shapeTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", NUMBER_AGE);
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "Anna");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isTrue();
    }
}
