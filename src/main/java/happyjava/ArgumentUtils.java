package happyjava;

@SuppressWarnings(value = "unused")
public class ArgumentUtils {
    /**
     * 从命令行或环境变量获取指定参数的值，优先级：命令行 > 环境变量
     *
     * 命令行参数：
     *      1. System.setProperty("log_dir", "/tmp/log");
     *      2. java -jar jarName -D propertyName=value
     *
     * @param name 参数名称
     * @param defaultValue 参数默认值
     * @return （默认）参数值
     */
    public static String getArgFromCmdOrEnv(String name, String defaultValue) {
        String value;

        if (System.getProperties().containsKey(name)) {
            value = System.getProperty(name, defaultValue);
        } else if (System.getenv().containsKey(name)) {
            value = System.getenv(name);
        } else {
            value = defaultValue;
        }

        return value;
    }

    /**
     * 从命令行或环境变量获取指定参数的值，优先级：命令行 > 环境变量
     *
     * 命令行参数：
     *      1. System.setProperty("log_dir", "/tmp/log");
     *      2. java -jar jarName -D propertyName=value
     *
     * @param name 参数名称
     * @return null或参数值
     */
    public static String getArgFromCmdOrEnv(String name) {
        String value;

        value = System.getProperty(name, null);

        if (value == null) {
            value = System.getenv(name);
        }

        return value;
    }

    /**
     * 从命令行获取指定参数的值
     *
     * 命令行参数：
     *      1. System.setProperty("log_dir", "/tmp/log");
     *      2. java -jar jarName -D propertyName=value
     *
     * @param name 参数名称
     * @return null或参数值
     */
    public static String getArgFromCmd(String name) {
        return System.getProperty(name, null);
    }

    /**
     * 从命令行获取指定参数的值
     *
     * 命令行参数：
     *      1. System.setProperty("log_dir", "/tmp/log");
     *      2. java -jar jarName -D propertyName=value
     *
     * @param name 参数名称
     * @return （默认）参数值
     */
    public static String getArgFromCmd(String name, String defaultValue) {
        return System.getProperty(name, defaultValue);
    }

    /**
     * 从环境变量获取指定参数的值
     *
     * 环境变量由操作系统设置
     *
     * @param name 参数名称
     * @return null或参数值
     */
    public static String getArgFromEnv(String name) {
        return System.getenv(name);
    }

    /**
     * 从环境变量获取指定参数的值
     *
     * 环境变量由操作系统设置
     *
     * @param name 参数名称
     * @return （默认）参数值
     */
    public static String getArgFromEnv(String name, String defaultValue) {
        return System.getenv().containsKey(name) ? System.getenv(name) : defaultValue;
    }

    /**
     * 新增参数到Java中（Property，非环境变量）
     * @param name 参数名称
     * @param value 参数值
     */
    public static void addNewArg(String name, String value) {
        System.setProperty(name, value);
    }
}
