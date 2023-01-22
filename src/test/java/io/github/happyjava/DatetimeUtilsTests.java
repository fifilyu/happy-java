package io.github.happyjava;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings(value = "unused")
public class DatetimeUtilsTests {
    @Test
    public void getNowTimeStamp() {
        assertEquals(Timestamp.class, DatetimeUtils.getNowTimeStamp().getClass());
    }
}
