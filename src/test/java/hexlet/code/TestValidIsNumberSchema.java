package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestValidIsNumberSchema {
    private static final Integer POSITIVE_NUMBER = 10;
    private static final Integer NEGATIVE_NUMBER = -1;
    private static final Integer MIN_BORDER = 5;
    private static final Integer MAX_BORDER = 10;
    private static final Integer NUMBER_OF_EXAMPLE = 11;
    private static final Integer NUMBER_OF_EXAMPLE2 = 7;
    @Test
    public void schemaTestIsRequired() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.required().isValid(null)).isFalse();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(0)).isTrue();
        assertThat(schema.isValid(NEGATIVE_NUMBER)).isTrue();
    }
    @Test
    public void schemaTetIsPositive() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertThat(schema.positive().isValid(POSITIVE_NUMBER)).isTrue();
        assertThat(schema.isValid(NEGATIVE_NUMBER)).isFalse();
        assertThat(schema.isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid(0)).isFalse();


    }

    @Test
    public void schemaTestIsRange() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        assertThat(schema.range(MIN_BORDER, MAX_BORDER).isValid(MIN_BORDER)).isTrue();
        assertThat(schema.range(MIN_BORDER, MAX_BORDER).isValid(NUMBER_OF_EXAMPLE2)).isTrue();
        assertThat(schema.range(MIN_BORDER, MAX_BORDER).isValid(MAX_BORDER)).isTrue();
        assertThat(schema.range(MIN_BORDER, MAX_BORDER).isValid(NUMBER_OF_EXAMPLE)).isFalse();
        assertThat(schema.range(MIN_BORDER, MAX_BORDER).isValid(null)).isFalse();
    }
}
