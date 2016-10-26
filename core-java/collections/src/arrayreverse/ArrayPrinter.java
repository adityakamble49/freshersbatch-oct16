package arrayreverse;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrayPrinter {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListIterator<Integer> li = list.listIterator(list.size());

        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }

    }

}
