package generics;

import java.util.ArrayList;
import java.util.List;

public class ListNumberRunner {

    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        printNumbers(list);
    }

}
