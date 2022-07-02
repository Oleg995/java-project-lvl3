package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestIsValidIsStringSchema {
    private static final Integer MIN_LENGTH = 5;
    @Test
    public void schemaTestRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();

        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();
    }

    @Test
    public void schemaTestLengthMin() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertThat(schema.isValid("Hi")).isTrue();
        assertThat(schema.minLength(MIN_LENGTH).isValid("Hi")).isFalse();
    }

    @Test
    public void schemaTestContains() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        assertThat(schema.contains("hello").isValid("hello Make")).isTrue();
        assertThat(schema.contains("Helllo").isValid("hello Make")).isFalse();
        assertThat(schema.isValid("hello Make")).isFalse();
    }
}
