import bl.HibernateUtil;
import entity.Color;
import entity.Order;
import entity.Paper;
import service.PaperService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramStart {
    public static void main(String[] args) throws SQLException {

//        Util util = new Util();
//        util.getConnection();

        PaperService paperService = new PaperService();

        //создаем экземпляр
        Paper paper = new Paper();
        //paper.setId(1_234_567_890L);
        paper.setName("меловка");
        paper.setWeight(300);

        //пишем в БД
        paperService.add(paper);
        HibernateUtil.shutdown();

        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order(Color.COLOR4_0, 1_234_567_890L,"доставка"));
        orderList.add(new Order(Color.COLOR4_4, 2_234_567_890L,"бартер"));
        orderList.add(new Order(Color.COLOR1_0, 3_234_567_890L,"в кредит"));
        orderList.add(new Order(Color.COLOR1_1, 4_234_567_890L,"срочно!"));
        orderList.add(new Order(Color.COLOR4_1, 5_234_567_890L,"доставка"));
        orderList.add(new Order());
        orderList.add(new Order());

        orderList.stream().map(Order::toString).forEach(System.out::println);

//        for (entity.Color color: entity.Color.values())
//            System.out.println(color);

    }
}