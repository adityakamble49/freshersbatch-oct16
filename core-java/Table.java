import java.util.*;
public class Table{
    public static void main(String args[]){
        System.out.println("Enter Number : ");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        for(int i=1; i<=10; i++){
            System.out.println(number*i);
        }
    }
}
