import java.time.LocalDateTime;
import java.util.ArrayList;

public class ProgramStart {
    public static void main(String[] args) {
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(new Order(LocalDateTime.now(), "4+0", 1_234_567_890L,"доставка"));
        orderList.add(new Order(LocalDateTime.now(), "4+4", 1_234_567_890L,"доставка"));
        orderList.add(new Order(LocalDateTime.now(), "1+0", 1_234_567_890L,"доставка"));
        orderList.add(new Order(LocalDateTime.now(), "4+1", 1_234_567_890L,"доставка"));

        orderList.stream().map(Order::toString).forEach(System.out::println);

    }
}