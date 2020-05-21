package com.github.mabutamail.tipograf.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tg_order")
public class PrintOrder implements Serializable {

    private Integer orderId;
    private LocalDateTime createDate;
    private Client client;
    private Long price;
    private String comment;
    private OrderCondition condition;

    public PrintOrder() {
        this.createDate = LocalDateTime.now();
        this.condition = OrderCondition.ACCEPTED;
    }

    public PrintOrder(Client client, Long price) {
        this.createDate = LocalDateTime.now();
        this.client = client;
        this.price = price;
        this.condition = OrderCondition.ACCEPTED;
    }

    public PrintOrder(Client client, Long price, String comment) {
        this.createDate = LocalDateTime.now();
        this.client = client;
        this.price = price;
        this.comment = comment;
        this.condition = OrderCondition.ACCEPTED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", unique = true, nullable = false)
    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    //    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE", unique = true, nullable = false)
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    public Client getClient() {
        return this.client;
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

    @Column(name = "CONDITION", nullable = false)
    public OrderCondition getCondition() {
        return condition;
    }

    public void setCondition(OrderCondition condition) {
        this.condition = condition;
    }
}