package hexlet.code;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MapSchemaTest {
    private Validator v = new Validator();

    @Test
    void isValidNullAfterReq() {
        var schema = v.map();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();
    }

    @Test
    void isvalidTest() {
        var schema = v.map();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    void sizeofTest() {
        var schema = v.map();
        schema.sizeof(2);
        var data = new HashMap<String, String>();
        assertThat(schema.isValid(data)).isFalse();
        data.put("key1","value1");
        assertThat(schema.isValid(data)).isFalse();
    }
}