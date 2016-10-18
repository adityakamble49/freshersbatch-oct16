import java.util.*;

public class DessertShopApp {

    public static void main(String[] args){

        ArrayList<DessertItem> dessertItemList =
            new ArrayList<DessertItem>();
        ArrayList<DessertItem> orderList = new ArrayList<DessertItem>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("1. Owner");
            System.out.println("2. Customer");
            int choice = scanner.nextInt();

            switch(choice){
                case 1:

                    System.out.println("1. Candy");
                    System.out.println("2. Cookie");
                    System.out.println("3. IceCream");

                    System.out.println("Add Desert Item : ");
                    int addChoice = scanner.nextInt();
                    switch(addChoice){
                        case 1:
                            dessertItemList.add(new Candy(scanner.next(),
                                        scanner.nextInt()));
                            break;
                        case 2:
                            dessertItemList.add(new Cookie(scanner.next(),
                                        scanner.nextInt()));
                            break;
                        case 3:
                            dessertItemList.add(new IceCream(scanner.next(),
                                        scanner.nextInt()));
                            break;
                    }
                    break;
                case 2:
                    for(int i=0; i<dessertItemList.size(); i++){
                        System.out.println(i + " : " +
                                dessertItemList.get(i).getName() + " - " +
                                dessertItemList.get(i).getCost());
                    }
                    System.out.println("Select Desert Items " +
                             " ( -1 to end ) : ");
                    int orderChoice = scanner.nextInt();
                    while(orderChoice>-1){
                        orderList.add(dessertItemList.get(orderChoice));
                        orderChoice = scanner.nextInt();
                    }
                    int totalPrice = DessertFactory.order(orderList);
                    System.out.println("Ordered Items : ");
                    for(int i=0; i<orderList.size(); i++){
                        System.out.println(i + " : " +
                                orderList.get(i).getName() + " - " +
                                orderList.get(i).getCost());
                    }
                    System.out.println("Total Cost :  " + totalPrice);
                    orderList.clear();
                    break;
            }
        }
    }
}

class DessertFactory {
    public static int order(ArrayList<DessertItem> orderList){
        int totalPrice = 0;
        for(int i=0; i<orderList.size(); i++){
            totalPrice += orderList.get(i).getCost();
        }
    return totalPrice;
    }
}

abstract class DessertItem {

    String name;
    int price;

    public abstract int getCost();

    public String getName(){
        return name;
    }
}

class Candy extends DessertItem {

    public Candy(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getCost(){
        return price*60;
    }
}

class Cookie extends DessertItem {

    public Cookie(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getCost(){
        return price*70;
    }
}

class IceCream extends DessertItem {

    public IceCream(String name, int price){
        this.name = name;
        this.price = price;
    }

    public int getCost(){
        return price;
    }
}
