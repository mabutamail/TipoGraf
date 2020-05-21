package com.github.mabutamail.tipograf.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tg_client")
public class Client implements Serializable {

    private Integer clientId;
    private String clientName;
    private String clientComment;
    private Set<PrintOrder> printOrders = new HashSet<>();

    public Client() {
    }

    public Client(String clientName, String clientComment) {
        this.clientName = clientName;
        this.clientComment = clientComment;
    }

    public Client(String clientName, String clientComment, Set<PrintOrder> printOrders) {
        this.clientName = clientName;
        this.clientComment = clientComment;
        this.printOrders = printOrders;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CLIENT_ID", unique = true, nullable = false)
    public Integer getClientId() {
        return this.clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Column(name = "CLIENT_NAME", unique = true, nullable = false, length = 20)
    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Column(name = "CLIENT_COMMENT", unique = true, nullable = false, length = 40)
    public String getClientComment() {
        return this.clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    public Set<PrintOrder> getPrintOrders() {
        return this.printOrders;
    }

    public void setPrintOrders(Set<PrintOrder> printOrders) {
        this.printOrders = printOrders;
    }
}