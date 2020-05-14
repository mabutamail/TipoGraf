package ru.zalex.tipograf.model;

import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;

@Entity
@Table(name = "tg_order")
public class PrintOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "order_number")
    private Long number;
    @Column(name = "order_createDate")
    private LocalDateTime localDateTime = LocalDateTime.now();
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @Column(name = "order_client")
    private Client client;
    @Column(name = "order_price")
    private Long price;
    @Column(name = "order_comment")
    private String comment;
    @Column(name = "order_condition")
    private OrderCondition condition;

    public PrintOrder() {
    }

}