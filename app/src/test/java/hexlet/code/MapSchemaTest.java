package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MapSchemaTest {
    private Validator v = new Validator();
    private MapSchema schema;

    @BeforeEach
    void init() {
        schema = v.map();
    }

    @Test
    void isValidNullAfterReq() {
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();
    }

    @Test
    void isvalidTest() {
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    void sizeofTest() {
        schema.sizeof(2);
        var data = new HashMap<String, String>();
        assertThat(schema.isValid(data)).isFalse();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isFalse();
    }

    @Test
    void shape() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);

        //NULL
        Map<String, String> human0 = new HashMap<>();
        human0.put("thirdname", "Petr");
        assertThat((schema.isValid(human0))).isFalse();

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertThat((schema.isValid(human1))).isTrue();

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertThat((schema.isValid(human2))).isFalse();

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertThat((schema.isValid(human3))).isFalse();
    }

    //type of data
    @Test
    void shapeData() {
        Map<String, BaseSchema<Integer>> schemas = new HashMap<>();
        schemas.put("firstvalue", v.number().positive());
        schema.shape(schemas);
        Map<String, String> human4 = new HashMap<>();
        human4.put("key", "5");
        assertThat((schema.isValid(human4))).isFalse();


    }



}
