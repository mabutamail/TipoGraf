package ru.zalex.tipograf.main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;

public class ProgramStart {
    private static final Logger logger = LogManager.getRootLogger();
    // private static final Logger logger = LoggerFactory.getLogger(ProgramStart.class);

    @Test
    private static void metod() {
        logger.trace("запущен method");
        metod1();
    }

    private static void metod1() {
        metod2();
    }

    private static void metod2() {
        //metod();
        return;
    }

    public static void main(String[] args) {
        metod();
        logger.trace("запущен main");
    }
}