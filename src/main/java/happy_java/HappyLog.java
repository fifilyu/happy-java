package happy_java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings(value = "unused")
public class HappyLog {
    private final Logger logger;

    public HappyLog(Logger logger) {
        this.logger = logger;
    }

    public HappyLog(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public void enterFunc(String funcName) {
        logger.trace(String.format("Enter function: %s", funcName));
    }

    public void exitFunc(String funcName) {
        logger.trace(String.format("Exit function: %s", funcName));
    }

    public <T> void var(String name, T value) {
        logger.trace(String.format("var->%s=%s", name, value));
    }

    public <T> void input(String name, T value) {
        logger.trace(String.format("input->%s=%s", name, value));
    }

    public <T> void output(String name, T value) {
        logger.trace(String.format("output->%s=%s", name, value));
    }

    public void error(String s) {
        logger.error(s);
    }

    public void warn(String s) {
        logger.warn(s);
    }

    public void info(String s) {
        logger.info(s);
    }

    public void debug(String s) {
        logger.debug(s);
    }

    public void trace(String s) {
        logger.trace(s);
    }
}
