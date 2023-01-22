package io.github.happyjava;

import io.github.happyjava.DatetimeUtils;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;

@SuppressWarnings(value = "unused")
public class DatetimeUtilsTests {
    @Test
    public void getNowTimeStamp() {
        assertEquals(Timestamp.class, DatetimeUtils.getNowTimeStamp().getClass());
    }
}
