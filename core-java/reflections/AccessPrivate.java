import java.lang.reflect.Field;

public class AccessPrivate {
    public static void main(String[] args) throws Exception {

        Class c = SomethingPrivate.class;
        Field privateField = c.getDeclaredField("name");
        privateField.setAccessible(true);

        System.out.println(
                "Private Name : " + privateField.get(new SomethingPrivate()));

    }
}

class SomethingPrivate {
    private String name = "Aditya";
}