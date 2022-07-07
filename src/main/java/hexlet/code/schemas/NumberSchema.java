package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public final NumberSchema required() {
        Predicate<Object> predicate = (Object o) -> o instanceof Integer s;
        addValidation(predicate);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Object> predicate = (Object o) -> {
            if (o instanceof Integer s) {
                return s > 0;
            }
            return true;
        };
        addValidation(predicate);
        return this;
    }

    public final NumberSchema range(Integer minBorders, Integer maxBorders) {
        Predicate<Object> predicate = (Object o) -> {
            if (o instanceof Integer s) {
                return s >= minBorders && s <= maxBorders;
            }
            return false;
        };
        addValidation(predicate);
        return this;
    }
}
