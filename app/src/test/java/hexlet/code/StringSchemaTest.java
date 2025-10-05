package hexlet.code;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.function.Predicate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringSchemaTest {
    private Validator v = new Validator();

    @Test
    void nullStr() {
        var schema = v.string();
        assertThat(schema.isValid(null)).isTrue();
    }

    @Test
    void empthyStr() {
        var schema = v.string();
        assertThat(schema.isValid("")).isTrue();

    }

    @Test
    void required() {
        var schema = v.string().required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("")).isFalse();
    }

    @Test
    void minLength() {
        var schema = v.string().required().minLength(10);
        assertThat(schema.isValid("Тестовая строка")).isTrue();
    }

    @Test
    void contains() {
        var schema = v.string().required().minLength(10).contains("крев");
        assertThat(schema.contains("крев").isValid("Сегодня на ужин будут креветки")).isTrue();
    }

    @Test
    void addCheck() {
        var cheks = new ArrayList<Predicate<String>>();
        cheks.add(d -> d.length() > 5);
        var x = cheks.get(0);
        assertThat(x.test("тест")).isFalse();
    }
}
