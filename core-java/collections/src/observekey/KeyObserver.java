package observekey;

import java.util.HashMap;
import java.util.Map;

public class KeyObserver {

    public static void main(String[] args) {

        Map<Employee, String> hm = new HashMap<Employee, String>();
        hm.put(new Employee(), "ABC");
        hm.put(new Employee(), "BVCC");
        hm.put(new Employee(), "ERD");
        hm.put(new Employee(), "AFASF");

        System.out.println(hm.get(new Employee()));
    }
}
