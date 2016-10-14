import java.util.*;
public class Armstrong{
    public static void main(String args[]){
        String number;
        System.out.println("Enter Number : ");
        Scanner scanner = new Scanner(System.in);
        number = scanner.next();
        int originalNumber = Integer.parseInt(number);
        int len = number.length();
        int sum = 0;

        for(int i=0; i<len; i++){
            int tempNum = Integer.parseInt(String.valueOf(number.charAt(i)));
            sum += Math.pow(tempNum,3);
        }

        if(sum==originalNumber){
            System.out.println("Armstrong Number");
        }else{
            System.out.println("Not Armstrong Number");
        }
    }
}
