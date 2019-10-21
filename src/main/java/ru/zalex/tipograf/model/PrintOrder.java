package ru.zalex.tipograf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class PrintOrder {
    //поля - состояние
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime localDateTime;
    private Client client;
    private Long price;
    private String comment;

    //конструктор
    public PrintOrder() {
        this.localDateTime = LocalDateTime.now();
        this.price = 0L;
        this.comment = "примечание";
    }

    public PrintOrder(Client client, Long price, String comment) {
        this.localDateTime = LocalDateTime.now();
        this.client = client;
        this.price = price;
        this.comment = comment;
    }

    //геттеры и сеттеры
//    public void setId(AtomicInteger id) {
//        this.id = id;
//    }
//    public void setLocalDateTime(LocalDateTime localDateTime) {
//        this.localDateTime = localDateTime;
//    }
//    public void setColor(ru.zalex.tipograf.model.Color color) {
//        this.color = color;
//    }
//    public void setPrice(long price) {
//        this.price = price;
//    }
//    public void setComment(String comment) {
//        this.comment = comment;
//    }



    @Override
    public String toString() {
        return "Заказ № " + id +
                " дата " + localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss")) +
                " цвет " + client +
                " цена " + price + " руб" +
                " примечание: " + comment;
    }
}