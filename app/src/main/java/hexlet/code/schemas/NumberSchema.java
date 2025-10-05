package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCheck(Objects::nonNull);
        this.required = true;
        return this;
    }

    public NumberSchema positive() {
        addCheck(data -> data == null || data > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck(data -> data == null || (data >= min && data <= max));
        return this;
    }
}
