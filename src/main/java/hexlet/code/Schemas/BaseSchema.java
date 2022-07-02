package hexlet.code.Schemas;

import java.util.LinkedList;
import java.util.List;

import java.util.function.Predicate;

public abstract class BaseSchema {
    private final List<Predicate<Object>> predicates = new LinkedList<>();

    public final boolean isValid(Object o) {
        return predicates.stream().allMatch(p -> p.test(o));
    }

    public final List<Predicate<Object>> getPredicates() {
        return predicates;
    }

    public final void clean() {
        predicates.clear();
    }
}
