package generics;

import java.util.HashMap;
import java.util.Map;

public class KeyValRunner {

    public static void printMapKeyValues(Map<? extends Number, ?> map) {

        for (Map.Entry<? extends Number, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "ABC");
        map.put(2, "XYZ");
        map.put(3, "PQR");
        map.put(4, "MNO");

        printMapKeyValues(map);
    }

}
