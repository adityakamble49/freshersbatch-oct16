package person;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PersonRunner {

    public static void main(String[] args) {

        Set<Person> personSet = new TreeSet<Person>();
        personSet.add(new Person("ABC", 159.8, 68.0));
        personSet.add(new Person("PQR", 158.0, 54.5));
        personSet.add(new Person("XYZ", 168.8, 54.5));
        personSet.add(new Person("MNO", 157.8, 68.5));

        Iterator<Person> personIterator = personSet.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
        }
    }
}
