package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private Map<String, Predicate<T>> checks = new HashMap<>();

    public boolean isValid(T data) {
        // Если не добавлен "required" и данные null - валидно
        if (!checks.containsKey("required") && data == null) {
            return true;
        }

        // Если добавлен "required" и данные null - невалидно
        if (checks.containsKey("required") && data == null) {
            return false;
        }

        //Пробегаем список проверок
        for (var check : checks.values()) {
            if (!check.test(data)) {
                return false;
            }
        }
        return true;
    }

    //Если добавляется новая того же типа - затирает предыдущую
    public void addCheck(String name, Predicate<T> check) {
        checks.put(name, check);
    }
}
