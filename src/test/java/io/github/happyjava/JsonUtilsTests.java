package io.github.happyjava;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonUtilsTests {
    @Test
    public void fromJsonTest() {
        JsonTest jsonTest =
                JsonUtils.fromJson("{\"name\": \"hello\", \"value\": \"world\"}", JsonTest.class);
        assertNotNull(jsonTest);
        assertEquals("hello", jsonTest.name);
        assertEquals("world", jsonTest.value);

        JsonTest jsonTest2 =
                JsonUtils.fromUpperCaseJson("{\"Name\": \"hello\", \"Value\": \"world\"}", JsonTest.class);
        assertNotNull(jsonTest2);
        assertEquals("hello", jsonTest2.name);
        assertEquals("world", jsonTest2.value);
    }

    @Test
    public void fromJsonTest2() {
        Map<Object, Object> jsonTest =
                JsonUtils.fromJson("{\"Name\": \"hello\", \"Value1\": 2, \"Value2\": null}");
        assertNotNull(jsonTest);
        assertEquals("hello", jsonTest.get("Name"));
        assertEquals(2, jsonTest.get("Value1"));
        assertNull(jsonTest.get("Value2"));
    }

    @Test
    public void toJsonTest() {
        Map<String, String> foo = new HashMap<>();
        foo.put("name", "hello");
        foo.put("value", "world");

        String json = JsonUtils.toJson(foo);
        assertEquals("{\n  \"name\": \"hello\",\n  \"value\": \"world\"\n}", json);
    }

    @Test
    public void toUpperCaseJsonTest() {
        Map<String, String> foo = new HashMap<>();
        foo.put("Name", "hello");
        foo.put("Value", "world");

        String json = JsonUtils.toUpperCaseJson(foo);
        assertEquals("{\n  \"Value\": \"world\",\n  \"Name\": \"hello\"\n}", json);
    }

    public static class JsonTest {
        String name;
        String value;
    }
}
