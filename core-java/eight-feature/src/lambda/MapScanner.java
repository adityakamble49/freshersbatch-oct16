package lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapScanner {

    private static StringBuilder mapString = new StringBuilder();

    private static void displayMap(Map<Integer, String> map,
            BiFunction<Integer, String, String> mapScanner) {

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            mapString
                    .append(mapScanner.apply(entry.getKey(), entry.getValue()));
        }
    }

    public static void main(String[] args) {

        Map<Integer, String> nameMap = new HashMap<Integer, String>();
        nameMap.put(1, "aditya");
        nameMap.put(2, "akshay");
        nameMap.put(3, "piyush");

        BiFunction<Integer, String, String> mapScannerFunction = (Integer i,
                String s) -> String.valueOf(i) + " " + s + "\n";

        displayMap(nameMap, mapScannerFunction);

        System.out.println(mapString);
    }
}
