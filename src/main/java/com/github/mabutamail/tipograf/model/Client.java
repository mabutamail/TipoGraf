package com.github.mabutamail.tipograf.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tg_client")
@NamedQuery(name = "Client.getAll", query = "SELECT c from Client c")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long clientId;
    @Column(name = "name", unique = true, nullable = false, length = 40)
    private String clientName;
    @Column(name = "comment", nullable = false, length = 40)
    private String clientComment;
    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "client")
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

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientComment() {
        return this.clientComment;
    }

    public void setClientComment(String clientComment) {
        this.clientComment = clientComment;
    }

    public Set<PrintOrder> getPrintOrders() {
        return this.printOrders;
    }

    public void setPrintOrders(Set<PrintOrder> printOrders) {
        this.printOrders = printOrders;
    }

    @Override
    public String toString() {
        return "\nClient{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", clientComment='" + clientComment + '\'' +
                '}' + "\n";
    }
}