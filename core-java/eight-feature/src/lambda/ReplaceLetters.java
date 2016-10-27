package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceLetters {

    public static void main(String[] args) {

        List<String> nameList = new ArrayList<String>();
        nameList.add("abcd");
        nameList.add("abcde");
        nameList.add("abcder");
        nameList.add("qwerty");
        nameList.add("ree");

        UnaryOperator<String> upperCaseOperator = (String s) -> s.toUpperCase();

        nameList.replaceAll(upperCaseOperator);

        System.out.println(nameList);
    }
}
