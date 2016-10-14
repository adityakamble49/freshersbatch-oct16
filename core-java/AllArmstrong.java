import java.util.*;
public class AllArmstrong{
    public static void main(String args[]){

        for (int j = 100; j<=999; j++){

            String number;
            number = String.valueOf(j);
            int originalNumber = Integer.parseInt(number);
            int len = number.length();
            int sum = 0;

            for(int i=0; i<len; i++){
                int tempNum = Integer.parseInt(String.valueOf(number.charAt(i)));
                sum += Math.pow(tempNum,len);
            }

            if(sum==originalNumber){
                System.out.println(originalNumber);
            }

        }

    }
}
