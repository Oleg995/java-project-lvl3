package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public final StringSchema required() {
        Predicate<Object> predicate = (Object o) -> {
            if (o instanceof String s) {
                return !s.isEmpty();
            }
            return false;
        };
        addValidation(predicate);
        return this;
    }

    public final StringSchema minLength(int number) {
        Predicate<Object> predicate = (Object o) -> {
            if (o instanceof String s) {
                return s.length() >= number;
            }
            return false;
        };
        addValidation(predicate);
        return this;
    }

    public final StringSchema contains(String str) {
        Predicate<Object> predicate = (Object o) -> {
            if (o instanceof String s) {
                return s.contains(str);
            }
            return false;
        };
        addValidation(predicate);
        return this;
    }
}
