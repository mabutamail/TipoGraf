import java.util.ArrayList;

public class ProgramStart {
    public static void main(String[] args) {
        ArrayList<Order> orderList = new ArrayList<Order>();

        orderList.add(0,new Order(3,"нужна доставка1",1_234_567_890L));
        orderList.add(1,new Order(2,"нужна доставка2",1_234_567_890L));
        orderList.add(2,new Order(1,"нужна доставка3",1_234_567_890L));

        orderList.stream().map(Order::toString).forEach(System.out::println);
    }
}
