import java.util.ArrayList;
import java.util.List;

public class ProgramStart {
    public static void main(String[] args) {

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(Color.COLOR4_0, 1_234_567_890L,"доставка"));
        orderList.add(new Order(Color.COLOR4_4, 2_234_567_890L,"бартер"));
        orderList.add(new Order(Color.COLOR1_0, 3_234_567_890L,"в кредит"));
        orderList.add(new Order(Color.COLOR1_1, 4_234_567_890L,"срочно!"));
        orderList.add(new Order(Color.COLOR4_1, 5_234_567_890L,"доставка"));
        orderList.add(new Order());
        orderList.add(new Order());

        orderList.stream().map(Order::toString).forEach(System.out::println);

//        for (Color color: Color.values())
//            System.out.println(color);

    }
}