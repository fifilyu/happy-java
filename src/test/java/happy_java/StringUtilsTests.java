package happy_java;

import happy_java.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings(value = "unused")
public class StringUtilsTests {
    @Test
    public void bytesToHexTest() {
        byte[] cdGeekCamp = "happy-java".getBytes();
        assertEquals("68617070792d6a617661", StringUtils.bytesToHex(cdGeekCamp));
    }
}
