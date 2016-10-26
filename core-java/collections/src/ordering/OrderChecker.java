package ordering;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class OrderChecker {

    public static void main(String[] args) {

        Set<Integer> hset = new HashSet<Integer>();
        hset.add(2);
        hset.add(1);
        hset.add(3);

        Set<Integer> lhset = new LinkedHashSet<Integer>();
        lhset.add(1);
        lhset.add(2);
        lhset.add(3);

        for (Integer i : hset) {
            System.out.println(i);
        }

        System.out.println();

        for (Integer i : lhset) {
            System.out.println(i);
        }
    }

}
