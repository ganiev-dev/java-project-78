package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        this.required = true;
        addCheck(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(data -> data != null && data.size() == size);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> MapSchema shape(Map<?, BaseSchema<T>> schemas) {
        addCheck((data) -> schemas.entrySet().stream()
                .allMatch(entry -> {
                    //получаем ключ
                    var key = entry.getKey();
                    //получаем схему для текущего ключа
                    BaseSchema<T> schema = entry.getValue();
                    //проверяем наличие текущего ключа в данных и валидность значения
                    return data.containsKey(key) && schema.isValid((T) data.get(key));
                }));
        return this;
    }
}
