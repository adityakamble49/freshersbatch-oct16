
public class Order {

    private int id;
    private String name;
    private int quantity;
    private double price;
    private Status s;

    public Order(int id, String name, int quantity, double price, Status s) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.s = s;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + quantity + " " + price + " " + s;
    }

    public static void main(String[] args) {

        Order o1 = new Order(1, "Pen", 3, 32, Status.NEW);
        Order o2 = new Order(2, "Computer", 3, 32000, Status.COMPLETED);
        System.out.println(o1);
        System.out.println(o2);
    }
}
