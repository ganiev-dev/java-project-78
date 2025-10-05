package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", data -> data > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck("range", data -> data >= min && data <= max);
        return this;
    }
}
