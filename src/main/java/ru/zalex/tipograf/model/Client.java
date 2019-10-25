package ru.zalex.tipograf.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name ="tg_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="client_id")
    private Long id;
    @Column(name ="client_name")
    private String name;
    @Column(name ="client_comment")
    private String comment;


    public Client() {
    }

    public Client(long id, String name, String comment) {
        this.id = id;
        this.name = name;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(comment, client.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, comment);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + comment + '\'' +
                '}';
    }
}