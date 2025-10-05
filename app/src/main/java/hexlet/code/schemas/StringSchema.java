package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck("required", data -> !data.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength)  {
        addCheck("minLength", data -> data.length() >= minLength);
        return this;
    }

    public StringSchema contains(String containsStr) {
        addCheck("contains", data -> data.contains(containsStr));
        return this;
    }
}
