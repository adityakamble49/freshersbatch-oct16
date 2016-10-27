package lambda;

@FunctionalInterface
interface MathOperation<T extends Number> {
    public T performOperation(T num1, T num2);
}

public class Arithmatic {

    public static void main(String[] args) {

        MathOperation<Integer> addition = (Integer num1, Integer num2) -> num1
                + num2;
        MathOperation<Integer> subtraction = (Integer num1,
                Integer num2) -> num1 - num2;
        MathOperation<Integer> multiplication = (Integer num1,
                Integer num2) -> num1 * num2;
        MathOperation<Integer> division = (Integer num1, Integer num2) -> num1
                / num2;

        calculator(1, 2, addition);
        calculator(3, 2, subtraction);
        calculator(4, 2, multiplication);
        calculator(10, 5, division);

    }

    public static void calculator(Integer num1, Integer num2,
            MathOperation<Integer> operation) {
        System.out.println(operation.performOperation(num1, num2));
    }
}
