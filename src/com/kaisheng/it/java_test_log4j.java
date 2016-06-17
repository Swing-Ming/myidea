package com.kaisheng.it;
import org.apache.log4j.Logger;
import org.junit.Test;
public class java_test_log4j {
    @Test
    public void test(){
        Logger logger = Logger.getLogger(java_test_log4j.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");

    }
}
