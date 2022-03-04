package happyjava;

@SuppressWarnings(value = "unused")
public class IntegerUtils {
    /**
     * 检查TCP/IP协议端口号
     *
     * @param port 端口号
     * @return boolean 布尔值结果
     * @author FifiLyu
     * @since 2022-02-22
     */
    public static boolean isPort(Integer port) {
        return port != null && port >= 0 && port <= 65535;
    }
}
