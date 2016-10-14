import java.util.*;
public class Marks{
    public static void main(String args[]){
        System.out.println("Enter marks of 3 subjects: ");
        Scanner scanner = new Scanner(System.in);
        int sub1 = scanner.nextInt();
        int sub2 = scanner.nextInt();
        int sub3 = scanner.nextInt();

        if(sub1 > 60 && sub2> 60 && sub3>60){
            System.out.println("Passed");
        }else if(
                sub1>60 && sub2>60 ||
                sub2> 60 && sub3>60 ||
                sub1> 60 && sub3>60
                ){
            System.out.println("Promoted");
                }
        else if(
                sub1>60 || sub2>60 || sub3> 60
               ){
                System.out.println("Failed");
        }else{
                System.out.println("Failed");
        }

    }
}
