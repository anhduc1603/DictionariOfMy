package com.example.dictionariofmy.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Test {
    private static final Logger logger = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");
    }
}
