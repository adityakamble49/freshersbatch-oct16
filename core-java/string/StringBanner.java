public class StringBanner {

    public static void main(String[] args) throws Exception {

        StringBuilder banner = new StringBuilder("Welcome To Java ");

        while(true){
            System.out.print("\r" + banner.toString());
            char firstChar = banner.charAt(0);
            banner.deleteCharAt(0);
            banner.append(firstChar);
            Thread.sleep(400);
        }
    }
}
