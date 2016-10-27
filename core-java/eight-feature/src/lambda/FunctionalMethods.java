package lambda;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalMethods {

    public static void main(String[] args) {

        Supplier<Integer> randomSupplier = () -> new Random().nextInt(10);
        Consumer<Integer> randomConsumer = (Integer i) -> System.out.println(i);
        Function<String, Integer> nameValueFunction = (String s) -> Integer
                .parseInt(s);
        Predicate<Integer> oddPredicate = (Integer i) -> i % 2 == 0 ? true
                : false;

        System.out.println(randomSupplier.get());
        randomConsumer.accept(10);
        System.out.println(nameValueFunction.apply("100"));
        System.out.println(oddPredicate.test(10));
    }
}
