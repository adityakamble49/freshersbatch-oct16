package lambda;

import java.util.ArrayList;
import java.util.List;

public class OddLengthRemoval {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<String>();
        nameList.add("abcd");
        nameList.add("abcde");
        nameList.add("abcder");
        nameList.add("qwerty");
        nameList.add("ree");

        nameList.removeIf(s -> s.length() % 2 != 0);

        System.out.println(nameList);
    }
}
