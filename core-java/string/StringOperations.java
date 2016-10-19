public class StringOperations {

    public static void changeString(String anyString){
        anyString += "Changed String";
    }

    public static void changeString(StringBuilder anyString){
        anyString.append("Changed String");
    }

    public static void changeString(StringBuffer anyString){
        anyString.append("Changed String");
    }

    public static void main(String[] args){

        String s1 = "ABC";
        String s2 = "ABC";
        String s3 = new String("ABC");
        String s4 = new String("ABC");

        if(s1==s2){
            System.out.println("s1 == s2");
        }

        if(s1.equals(s2)){
            System.out.println("s1 equals s2");
        }

        if(s3==s4){
            System.out.println("s3 == s4");
        }

        if(s3.equals(s4)){
            System.out.println("s3 equals s4");
        }

        String someString = "Hello";
        changeString(someString);
        System.out.println(someString);

        StringBuilder someStringBuilder = new StringBuilder("Hello Builder");
        changeString(someStringBuilder);
        System.out.println(someStringBuilder.toString());

        StringBuffer someStringBuffer = new StringBuffer("Hello Buffer");
        changeString(someStringBuffer);
        System.out.println(someStringBuffer.toString());
    }
}
