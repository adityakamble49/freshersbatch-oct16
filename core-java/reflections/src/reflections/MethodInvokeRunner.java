package reflections;

import java.lang.reflect.Method;

public class MethodInvokeRunner {
    public static void main(String[] args) throws Exception {

        String className = "reflections.Printer";
        String methodName = "printCapital";

        Class[] paramTypes = new Class[1];
        paramTypes[0] = String.class;

        Object[] paramValues = new Object[1];
        paramValues[0] = "Aditya";

        Object returnValue = MethodInvoker.invokeMethod(className, methodName,
                paramTypes, paramValues);

        System.out.println(returnValue);

    }
}

class MethodInvoker {
    public static Object invokeMethod(String className, String methodName,
            Class[] paramTypes, Object[] paramValues) throws Exception {

        Class c = Class.forName(className);
        Method method = c.getMethod(methodName, paramTypes);
        return method.invoke(c.newInstance(), paramValues);
    }
}

class Printer {
    public String printCapital(String s) {
        return s.toUpperCase();
    }
}