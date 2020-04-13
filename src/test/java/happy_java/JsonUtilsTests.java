package happy_java;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings(value = "unused")
public class JsonUtilsTests {
    private JsonUtils jsonUtils;

    public static class JsonTest {
        String name;
        String value;
    }

    @Before
    public void setUp() {
        jsonUtils = new JsonUtils();
    }

    @Test
    public void fromJsonTest() throws HappyJavaException {
        JsonTest jsonTest = jsonUtils.fromJson("{\"name\": \"happy-java\", \"value\": \"java\"}", JsonTest.class);
        assertEquals("happy-java", jsonTest.name);
        assertEquals("java", jsonTest.value);
    }
}
