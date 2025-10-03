package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCheck(data -> data != null && data != 0);
        return this;
    }
    public NumberSchema positive() {
        addCheck(data -> data > 0);
        return this;
    }
    public NumberSchema range(int min, int max) {
        addCheck(data -> min < data && data < max);
        return this;
    }
}
