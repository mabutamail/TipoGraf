package ru.zalex.tipograf.model;

import java.util.Objects;

public class Client {

    private long id;
    private String name;
    private String contact;

    public Client(long id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(contact, client.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contact);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}