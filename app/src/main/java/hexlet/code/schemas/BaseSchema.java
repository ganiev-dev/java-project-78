package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BaseSchema<T> {
    private ArrayList<Predicate<T>> checks = new ArrayList<>();

    public Boolean isValid(T data) {
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
