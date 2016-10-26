package safe;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionMain {

    public static void main(String[] args) {

        List<String> nameAryList = new CopyOnWriteArrayList<String>();
        nameAryList.add("Ivan");
        nameAryList.add("Tom");
        nameAryList.add("Jerry");

        Iterator<String> itr = nameAryList.iterator(); // Fail-fast iterator
        while (itr.hasNext()) {
            System.out.println(itr.next());
            nameAryList.add("Jenny");
        }

        Iterator<String> itr2 = nameAryList.iterator(); // Fail-fast iterator
        while (itr2.hasNext()) {
            System.out.println(itr2.next());
        }
    }

}
