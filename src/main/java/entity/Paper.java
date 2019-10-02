package entity;

import java.util.Objects;

public class Paper {
    //int id;
    private String name;
    private int weight;
   // String size;
   // int price;

    public Paper() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paper paper = (Paper) o;
        return weight == paper.weight &&
                Objects.equals(name, paper.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "Paper{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}