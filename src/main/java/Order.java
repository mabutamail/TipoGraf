import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;


@Entity
public class Order {
    //поля - состояние
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private AtomicInteger id;
    private LocalDateTime localDateTime;// = LocalDateTime.now();
    private String color = "4+0";
    private long price = 0;
    private String comment = "примечание";

    //конструктор
    public Order() {
    }

    public Order(LocalDateTime localDateTime, String color, long price, String comment) {
        //this.id = id;
        this.localDateTime = localDateTime;
        this.color = color;
        this.price = price;
        this.comment = comment;
    }


    //геттеры и сеттеры
    public void setId(AtomicInteger id) {
        this.id = id;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                '}';
    }
}
