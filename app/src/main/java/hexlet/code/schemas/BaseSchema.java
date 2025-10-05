package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private ArrayList<Predicate<T>> checks = new ArrayList<>();
    protected Boolean required = false;

    public Boolean isValid(T data) {
        if (!required && data == null) { //если рек не работал и null - валидно
            return true;
        }

        if (required && data == null) { //если рек сработал и null - не валидно
            return false;
        }

        for (Predicate<T> check : checks) {
            if (!check.test(data)) {
                return false;
            }
        }
        return true;
    }

    public void addCheck(Predicate<T> check) {
        checks.add(check);
    }
}
