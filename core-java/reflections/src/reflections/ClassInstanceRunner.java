package reflections;

import java.lang.reflect.Constructor;

public class ClassInstanceRunner {

    public static void main(String[] args) throws Exception {

        Object o = ClassInstanceCreator.instanceClass("reflections.InstanceMe");
        System.out.println(((InstanceMe) o).getName());
    }
}

class ClassInstanceCreator {
    public static Object instanceClass(String className) throws Exception {
        Class c = Class.forName(className);
        Constructor con = c.getDeclaredConstructor(String.class);
        return con.newInstance("Hello");
    }
}

class InstanceMe {

    String name;

    public InstanceMe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}