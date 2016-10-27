package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Order {
    private int id;
    private String name;
    private int price;
    private OrderStatus status;

    public Order(int id, String name, int price, OrderStatus status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + status;
    }
}

enum OrderStatus {
    ACCEPTED, COMPLETED;
}

public class OrderRunner {

    public static List<Order> filterOrders(List<Order> orderList,
            Predicate<Order> predicate) {

        List<Order> resultList = new ArrayList<Order>();

        for (Order o : orderList) {
            if (predicate.test(o)) {
                resultList.add(o);
            }
        }
        return resultList;

    }

    public static void main(String[] args) {

        List<Order> orderList = new ArrayList<Order>();
        orderList.add(new Order(1, "ABC", 2000, OrderStatus.ACCEPTED));
        orderList.add(new Order(2, "WBC", 12000, OrderStatus.COMPLETED));
        orderList.add(new Order(3, "RBC", 32000, OrderStatus.ACCEPTED));
        orderList.add(new Order(4, "RBC", 2000, OrderStatus.COMPLETED));
        orderList.add(new Order(5, "TBC", 10000, OrderStatus.ACCEPTED));

        Predicate<Order> pricePredicate = (Order o) -> o.getPrice() > 10000
                ? true : false;
        Predicate<Order> acceptPredicate = (Order o) -> o.getStatus()
                .equals(OrderStatus.ACCEPTED);
        Predicate<Order> completePredicate = (Order o) -> o.getStatus()
                .equals(OrderStatus.COMPLETED);

        List<Order> moreThan10000 = filterOrders(orderList, pricePredicate);
        List<Order> acceptedOrders = filterOrders(orderList, acceptPredicate);
        List<Order> completedOrders = filterOrders(orderList,
                completePredicate);

        System.out.println(moreThan10000);
        System.out.println(acceptedOrders);
        System.out.println(completedOrders);
    }

}
