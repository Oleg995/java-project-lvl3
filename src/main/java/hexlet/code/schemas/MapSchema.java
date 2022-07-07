package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {
    public final void required() {
        Predicate<Object> predicate = (Object o) -> o instanceof Map s;
        addValidation(predicate);
    }

    public final MapSchema sizeof(int size) {
        Predicate<Object> predicate = (Object o) -> {
            if (o instanceof Map s) {
                return s.size() == size;
            }
            return false;
        };
        addValidation(predicate);
        return this;
    }
    
    public final void shape(Map<String, BaseSchema> map) {
        Predicate<Object> predicate = (Object o) -> {
            if (o instanceof Map s) {
                boolean result = true;
                for (Map.Entry<String, BaseSchema> it : map.entrySet()) {
                    Object value = s.get(it.getKey());
                    result = result && it.getValue().isValid(value);
                }
                return result;
            }
            return false;
        };
        addValidation(predicate);
    }

}

