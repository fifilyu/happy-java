package happy_java;

import java.sql.Timestamp;

@SuppressWarnings(value = "unused")
public class DatetimeUtils {
    public static Timestamp getNowTimeStamp() {
        /*
         * 取得当前时间戳
         *
         * @return TimStamp
         */
        return new Timestamp(System.currentTimeMillis());
    }
}
