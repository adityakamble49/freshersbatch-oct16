package annotations;

import java.lang.reflect.Method;

public class CustomAnnotation {

    private int one = 1;
    private int two = 2;
    private int threee = 3;

    @Getter
    public int getOne() {
        return one;
    }

    @Getter
    public int getTwo() {
        return two;
    }

    @Getter
    public int getThree() {
        return threee;
    }

    public static void main(String[] args) {

        Class c = CustomAnnotation.class;
        Method[] m = c.getDeclaredMethods();

        for (int i = 0; i < m.length; i++) {
            if (m[i].getAnnotation(Getter.class) != null) {
                String methodName = m[i].getName().toLowerCase();
                String returnValue = methodName.substring(3,
                        methodName.length());
                System.out.print(returnValue + " = ");
                try {
                    if (c.getDeclaredField(returnValue) != null) {
                        System.out.print("found");
                        System.out.println();
                    }
                } catch (NoSuchFieldException e) {
                    System.err.println("Not Found");
                } catch (SecurityException e) {
                }

            }
        }
    }

}
