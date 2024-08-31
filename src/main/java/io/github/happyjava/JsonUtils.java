package io.github.happyjava;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings(value = "unused")
public class JsonUtils {
    private static final HappyLog log = new HappyLog(JsonUtils.class);

    // 解决Gson中Integer类型被转换成double的问题
    public static class MapTypeAdapter extends TypeAdapter<Object> {
        @Override
        public Object read(JsonReader in) throws IOException {
            JsonToken token = in.peek();

            switch (token) {
                case BEGIN_ARRAY:
                    List<Object> list = new ArrayList<>();
                    in.beginArray();

                    while (in.hasNext()) {
                        list.add(read(in));
                    }

                    in.endArray();
                    return list;
                case BEGIN_OBJECT:
                    Map<String, Object> map = new LinkedTreeMap<>();
                    in.beginObject();

                    while (in.hasNext()) {
                        map.put(in.nextName(), read(in));
                    }

                    in.endObject();
                    return map;
                case STRING:
                    return in.nextString();
                case NUMBER:
                    // 改写数字的处理逻辑，将数字值分为整型与浮点型。
                    String numberStr = in.nextString();

                    if (numberStr.contains(".") || numberStr.contains("e")
                            || numberStr.contains("E")) {
                        return Double.parseDouble(numberStr);
                    }

                    if (Long.parseLong(numberStr) <= Integer.MAX_VALUE) {
                        return Integer.parseInt(numberStr);
                    }

                    return Long.parseLong(numberStr);
                case BOOLEAN:
                    return in.nextBoolean();
                case NULL:
                    in.nextNull();
                    return null;
                default:
                    throw new IllegalStateException();
            }
        }

        @Override
        public void write(JsonWriter out, Object value) {
            // 序列化无需实现
        }
    }

    public static <T> T fromJson(String jsonString, Class<T> classOfT) {
        try {
            Gson gson = new GsonBuilder()
                    .serializeNulls()
                    .create();
            return gson.fromJson(jsonString, classOfT);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("JSON字符串转换到 JsonObject 对象错误");

            return null;
        }
    }

    public static <T> T fromUpperCaseJson(String jsonString, Class<T> classOfT) {
        try {
            Gson gson = new GsonBuilder()
                    .serializeNulls()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // 首字母大写
                    .create();
            return gson.fromJson(jsonString, classOfT);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("JSON字符串转换到 JsonObject 对象错误");

            return null;
        }
    }

    public static Map<Object, Object> fromJson(String jsonString) {
        Type type = new TypeToken<Map<Object, Object>>() {
        }.getType();

        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(type, new MapTypeAdapter()) // 保持数字格式，不强制转换为float
                    .serializeNulls() // 支持输出NULL
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // 首字母大写
                    .create();
            return gson.fromJson(jsonString, type);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("JSON字符串转换到 JsonObject 对象错误");

            return null;
        }
    }

    public static <T> String toUpperCaseJson(T t) {
        Type type = new TypeToken<Map<Object, Object>>() {
        }.getType();

        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(type, new MapTypeAdapter()) // 保持数字格式，不强制转换为float
                    .serializeNulls() // 支持输出NULL
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)  // 首字母大写
                    .setPrettyPrinting()
                    .create();
            return gson.toJson(t);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("对象转换到JSON字符串出现错误");

            return null;
        }
    }

    public static <T> String toJson(T t) {
        try {
            Gson gson = new GsonBuilder()
                    .serializeNulls() // 支持输出NULL
                    .setPrettyPrinting()
                    .create();
            return gson.toJson(t);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("对象转换到JSON字符串出现错误");

            return null;
        }
    }
}
