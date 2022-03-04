package happyjava;

@SuppressWarnings(value = "unused")
public class StringUtils {
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);

            if (hex.length() == 1)
                hexString.append('0');

            hexString.append(hex);
        }

        return hexString.toString();
    }

    /**
     * 判断IPv4字符串（递归）
     *
     * @param cc IPv4的字符数组
     * @param maxIndex 数组最大索引
     * @param index 数组索引
     * @param dotCount "."计数器
     * @param digitCount 数字计数器
     * @return boolean 布尔值结果
     * @author FifiLyu
     * @since 2022-02-22
     */
    private static boolean _isIPv4(char[] cc, Integer maxIndex, Integer index, Integer dotCount, Integer digitCount) {
        // 形参检查
        {
            // IPv4最长15个字符
            if (maxIndex > 14) {
                return false;
            }

            // 检查索引范围
            if (index < 0 || index > maxIndex) {
                return false;
            }
        }

        char currChar = cc[index];
        final boolean isDigit = Character.isDigit(currChar);
        final boolean isDot = currChar == '.';

        // "."相关的检查
        {
            // 不能以点开头或结尾
            if ((index == 0 || index.equals(maxIndex)) && isDot) {
                return false;
            }

            if (isDot) {
                ++dotCount;

                // 重置数字长度计数
                digitCount = 0;
            }

            // IPv4最多有3个点
            if (dotCount > 3) {
                return false;
            }
        }

        // IP数字长度检查
        {
            if (isDigit) {
                ++digitCount;
            }

            // IPv4最多有3个点
            if (digitCount > 3) {
                return false;
            }
        }

        if (isDot || isDigit) {
            // 检查完成，退出函数
            if (index.equals(maxIndex)) {
                return true;
            }

            return _isIPv4(cc, maxIndex, index + 1, dotCount, digitCount);
        }

        return false;
    }

    /**
     * 判断IPv4字符串
     *
     * @param s 字符串
     * @return boolean 布尔值结果
     * @author FifiLyu
     * @since 2022-02-22
     */
    public static boolean isIPv4(String s) {
        if (s == null) {
            return false;
        }

        final char[] cc = s.toCharArray();
        final Integer maxIndex = cc.length - 1;

        return _isIPv4(cc, maxIndex, 0, 0, 0);
    }

    /**
     * 检查TCP/IP协议端口号
     *
     * @param s 端口字符串
     * @return boolean 布尔值结果
     * @author FifiLyu
     * @since 2022-02-22
     */
    public static boolean isPort(String s) {
        if (s == null) {
            return false;
        }

        return isDigit(s) && IntegerUtils.isPort(Integer.valueOf(s));
    }

    /**
     * 判断字符串由纯数字组成
     *
     * @param s 字符串
     * @return boolean 布尔值结果
     * @author FifiLyu
     * @since 2020-07-13
     */
    public static boolean isDigit(String s) {
        if (s == null) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if ((!Character.isDigit(c))) {
                return false;
            }
        }

        return true;
    }
}