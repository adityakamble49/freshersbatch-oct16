package employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDateRunner {

    public static void main(String[] args) {

        Map<Date, String> empMap = new HashMap<Date, String>();

        empMap.put(new Date(11, 10, 1994), "ABC");
        empMap.put(new Date(12, 7, 1995), "XYZ");
        empMap.put(new Date(12, 7, 1997), "PQR");
        empMap.put(new Date(30, 4, 1992), "MNO");

        System.out.println(empMap.get(new Date(12, 7, 1995)));
    }
}
