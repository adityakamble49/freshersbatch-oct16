import java.util.*;
public class Lottery{
    public static void main(String args[]){
        Random random = new Random();
        int[] randomArray = new int[6];
        int[] userArray = new int[6];

        for (int i=0; i<6; i++){
            randomArray[i] = random.nextInt(49) + 1;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 6 numbers : ");

        for (int i=0; i<6; i++){
            int tempNum = scanner.nextInt();
            while(isDuplicate(tempNum,userArray)){
                System.out.println("Duplicate, Enter Again : ");
                tempNum = scanner.nextInt();
            }
            userArray[i] = tempNum;
        }

        System.out.println("Matched Numbers : ");
        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(userArray[i]==randomArray[j]){
                    System.out.println(userArray[i]);
                    break;
                }
            }
        }
    }

    public static boolean isDuplicate(int number, int[] array){
        for(int i=0; i<6; i++){
            if(number==array[i]){
                return true;
            }
        }
        return false;
    }
}
