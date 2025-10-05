package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        this.required = true;
        addCheck(data -> data != null && !data.isEmpty());
        return this;
    }

    public StringSchema minLength(int minLength)  {
        addCheck(data -> data == null || data.length() >= minLength);
        return this;
    }

    public StringSchema contains(String containsStr) {
        addCheck(data -> data == null || data.contains(containsStr));
        return this;
    }
}
