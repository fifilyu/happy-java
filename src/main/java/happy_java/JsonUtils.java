package happy_java;

import com.google.gson.Gson;

@SuppressWarnings(value = "unused")
public class JsonUtils {
    private final Gson gson;

    public JsonUtils() {
        this.gson = new Gson();
    }

    public <T> T fromJson(String jsonString, Class<T> classOfT) throws HappyJavaException {
        try {
            return gson.fromJson(jsonString, classOfT);
        } catch (Exception exception) {
            throw new HappyJavaException("JSON字符串转换到 JsonObject 对象错误");
        }
    }

    public <T> String toJson(T t) {
        return gson.toJson(t);
    }
}
