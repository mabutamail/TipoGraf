import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Order {
    //поля - состояние
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private AtomicInteger id;
    private LocalDateTime localDateTime;
    private Color color;
    private long price;
    private String comment;

    //конструктор
    public Order(AtomicInteger id, Color color, long price, String comment) {
        this.id = id;
        this.localDateTime = LocalDateTime.now();
        this.color = color;
        this.price = price;
        this.comment = comment;
    }

    //геттеры и сеттеры
//    public void setId(AtomicInteger id) {
//        this.id = id;
//    }
//    public void setLocalDateTime(LocalDateTime localDateTime) {
//        this.localDateTime = localDateTime;
//    }
//    public void setColor(Color color) {
//        this.color = color;
//    }
//    public void setPrice(long price) {
//        this.price = price;
//    }
//    public void setComment(String comment) {
//        this.comment = comment;
//    }

    @Override
    public String toString() {
        return "Заказ № " + id +
                " дата " + localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss")) +
                " цвет " + color +
                " цена " + price + " руб" +
                " примечание: " + comment;
    }
}