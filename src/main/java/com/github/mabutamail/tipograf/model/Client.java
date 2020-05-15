package com.github.mabutamail.tipograf.model;

import javax.persistence.*;

@Entity
@Table(name = "tg_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;
    @Column(name = "client_name")
    private String name;
    @Column(name = "client_comment")
    private String comment;

    public Client() {
    }

}