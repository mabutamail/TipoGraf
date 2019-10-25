package ru.zalex.tipograf.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name ="tg_order")
public class PrintOrder {
    //поля - состояние
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="order_id")
    private Long id;
    @Column(name ="order_createDate")
    private LocalDateTime localDateTime;
    @ManyToOne (cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @Column(name ="order_client")
    private Client client;
    @Column(name ="order_price")
    private Long price;
    @Column(name ="order_comment")
    private String comment;
    @Column(name ="order_paid")
    private boolean paid;

//    //конструктор
//    public PrintOrder() {
//        this.localDateTime = LocalDateTime.now();
//        this.price = 0L;
//        this.comment = "примечание";
//    }
//
//    public PrintOrder(Client client, Long price, String comment) {
//        this.localDateTime = LocalDateTime.now();
//        this.client = client;
//        this.price = price;
//        this.comment = comment;
//    }

    //геттеры и сеттеры


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Заказ № " + id +
                " дата " + localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm")) +
                " клиент " + client +
                " цена " + price + " руб" +
                " примечание: " + comment +
                " оплачен д/н: " + paid;
    }
}