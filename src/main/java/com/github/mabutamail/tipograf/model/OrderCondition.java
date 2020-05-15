package com.github.mabutamail.tipograf.model;

public enum OrderCondition {
    ACCEPTED("принят") {},
    IN_PROGRESS("в работе") {},
    IN_STOCK("на складе") {},
    IS_EXECUTED("выполнен") {},
    DELETED("удалён") {};

    OrderCondition(String s) {
    }

    OrderCondition() {
    }

}