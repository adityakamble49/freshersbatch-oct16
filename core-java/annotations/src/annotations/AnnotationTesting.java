package annotations;

@SuppressWarnings("deprecation")
public class AnnotationTesting {
    public static void main(String[] args) {
        new APIProvide().readThis("Hello");
    }
}

class APIProvide {
    @Deprecated
    public void readThis(String s) {
        System.out.println(s);
    }
}

class APIProviderNew extends APIProvide {
    @Override
    public void readThis(String s) {
        // TODO Auto-generated method stub
        super.readThis(s);
    }
}