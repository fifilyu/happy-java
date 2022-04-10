package happyjava;

import org.junit.Test;

import static org.junit.Assert.*;

@SuppressWarnings(value = "unused")
public class ArgumentUtilsTests {
    final String name = "log_dir";
    final String value = "/var/log";
    final String defaultValue = "/tmp/log";
    final String notExistsName = "notExistsName";

    @Test
    public void setUp() {
        ArgumentUtils.addNewArg(name, value);
    }

    @Test
    public void getArgFromCmdOrEnvTest() {
        assertEquals(value, ArgumentUtils.getArgFromCmdOrEnv(name, defaultValue));
        assertEquals(defaultValue, ArgumentUtils.getArgFromCmdOrEnv(notExistsName, defaultValue));

        assertNull(ArgumentUtils.getArgFromCmdOrEnv(notExistsName));
    }

    @Test
    public void getArgFromCmdTest() {
        assertEquals(value, ArgumentUtils.getArgFromCmd(name));
        assertEquals(defaultValue, ArgumentUtils.getArgFromCmd(notExistsName, defaultValue));

        assertNull(ArgumentUtils.getArgFromCmd(notExistsName));
    }

    @Test
    public void getArgFromEnvTest() {
        // Windows：echo %PATH%
        // Linux：echo $PATH
        assertNotNull(ArgumentUtils.getArgFromEnv("PATH"));
        assertEquals(defaultValue, ArgumentUtils.getArgFromEnv(notExistsName, defaultValue));

        assertNull(ArgumentUtils.getArgFromEnv(notExistsName));
    }
}
