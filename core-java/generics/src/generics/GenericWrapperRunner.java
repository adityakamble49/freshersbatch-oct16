package generics;

class GenericWrapper<T> {
    private T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}

public class GenericWrapperRunner {

    public static void main(String[] args) {

        GenericWrapper<String> name = new GenericWrapper<String>();
        name.setT("Aditya");
        System.out.println(name.getT());
    }
}
