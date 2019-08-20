public class Order {
    //поля - состояние
    private int id;
    private String comment;
    private long price;

    //конструктор
    public Order(int id, String comment, long price) {
        this.id = id;
        this.comment = comment;
        this.price = price;
    }

    //геттеры и сеттеры
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", price=" + price +
                '}';
    }

}
