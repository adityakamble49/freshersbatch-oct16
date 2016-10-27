package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PrintNumbers {

    public static void main(String[] args) {

        List<Integer> numberList = new ArrayList<Integer>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);

        Consumer<Integer> numberConsumer = (Integer i) -> System.out.println(i);

        Thread printNumbers = new Thread(() -> {
            for (Integer i : numberList) {
                numberConsumer.accept(i);
            }
        });

        printNumbers.start();
    }
}
