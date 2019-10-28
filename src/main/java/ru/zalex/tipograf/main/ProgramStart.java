/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package ru.zalex.tipograf.main;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import ru.zalex.tipograf.model.PrintOrder;
import java.util.ArrayList;
import java.util.List;

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
        List<PrintOrder> printOrderList = new ArrayList<>();
        printOrderList.add(new PrintOrder());
        System.out.println(printOrderList);

    }
}