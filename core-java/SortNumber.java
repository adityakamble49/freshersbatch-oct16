import java.util.*;
public class SortNumber{
    public static void main(String args[]){
        int[] numbers = new int[args.length];
        for(int i = 0; i<args.length; i++){
            numbers[i] = Integer.parseInt(args[i]);
        }

        Arrays.sort(numbers);
        for(int i = 0; i<args.length; i++){
            System.out.println(numbers[i]);
        }

    }
}
