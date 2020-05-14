package ru.zalex.tipograf;

import ru.zalex.tipograf.model.Client;
import ru.zalex.tipograf.model.OrderCondition;
import ru.zalex.tipograf.model.PrintOrder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProgramStart {
    public static void main(String[] args) {
        List<PrintOrder> printOrderList = new ArrayList<>();
//        Client client1 = new Client("Рога и Копыта","Антон 123-45-67");
//        PrintOrder zakaz1 = new PrintOrder(client1, 1_000_000L, "задерживают оплату", OrderCondition.ACCEPTED);
//        PrintOrder zakaz2 = new PrintOrder(client1, 987_000L, "оплачен", OrderCondition.IS_EXECUTED);
//        printOrderList.add(zakaz1);
//        printOrderList.add(zakaz2);
        System.out.println(printOrderList.toString());
        System.out.println("Конец программы " + LocalDateTime.now());
    }
}