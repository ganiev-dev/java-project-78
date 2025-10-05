package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {
    private ArrayList<Predicate<String>> checks = new ArrayList<>();

    public StringSchema required() {
        addCheck(data -> data != null && !data.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength)  {
        addCheck(data -> data.length() >= minLength);
        return this;
    }

    public StringSchema contains(String containsStr) {
        addCheck(data -> data != null && data.contains(containsStr));
        return this;
    }
}


