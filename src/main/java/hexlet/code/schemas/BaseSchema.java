package hexlet.code.schemas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate<Object>> predicates = new LinkedList<>();
// забываю правильно называть методы)
    final void addValidation(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    public final boolean isValid(Object o) {
        return predicates.stream().allMatch(p -> p.test(o));
    }

    public final void clean() {
        predicates.clear();
    }
}
