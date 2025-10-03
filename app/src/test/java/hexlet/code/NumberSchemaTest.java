package hexlet.code;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.function.Predicate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberSchemaTest {
    private Validator v = new Validator();

    @Test
    void nullStr() {
        var schema = v.number();
        assertThat(schema.isValid(null)).isTrue();
    }

    @Test
    void empthyStr() {
        var schema = v.number();
        assertThat(schema.isValid(0)).isTrue();
    }

    @Test
    void required() {
        var schema = v.number();
        assertThat(schema.isValid(null)).isTrue();
    }

    @Test
    void positive() {
        var schema = v.number().positive();
        assertThat(schema.isValid(0)).isFalse();
    }

    @Test
    void range() {
        var schema = v.number().range(4, 12);
        assertThat(schema.isValid(6)).isTrue();
    }

    @Test
    void addCheck() {
        var cheks = new ArrayList<Predicate<Integer>>();
        cheks.add(d -> d > 5);
        var x = cheks.get(0);
        assertThat(x.test(4)).isFalse();
    }
}