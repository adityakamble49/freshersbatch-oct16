
public class AutoClosableRunner {
    public static void main(String[] args) {
        try (MyAutoClosable mac = new MyAutoClosable()) {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyAutoClosable implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoClosable closed");
    }

}
