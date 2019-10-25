package ru.zalex.tipograf.main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;

public class ProgramStart {
   //private static final Logger logger = LogManager.getRootLogger();
   // private static final Logger logger = LoggerFactory.getLogger(ProgramStart.class);

   // @Test
    private static void metod() {
        //logger.trace("запущен method");
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
        System.out.println("ERROR StatusLogger No Log4j 2 configuration file found. \n" +
                "Using default configuration (logging only errors to the console), \n" +
                "or user programmatically provided configurations. \n" +
                "Set system property 'log4j2.debug' to show Log4j 2 internal initialization logging. \n" +
                "See https://logging.apache.org/log4j/2.x/manual/configuration.html \n" +
                "for instructions on how to configure Log4j 2\n");
        //logger.trace("что то сработало");
    }


}