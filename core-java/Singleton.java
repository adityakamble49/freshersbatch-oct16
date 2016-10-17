public class Singleton {

    private static Singleton singleton;
    String singleCheck = "aditya";

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(singleton==null){
            singleton = new Singleton();
        }
        return singleton;
    }

    public String checkSingleton(){
        return singleCheck;
    }

    public static void main(String args[]){
        Singleton s1 = Singleton.getInstance();
        s1.singleCheck = "aditya1";
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();

        System.out.println(s1.checkSingleton());
        System.out.println(s2.checkSingleton());
        System.out.println(s3.checkSingleton());
    }
}
