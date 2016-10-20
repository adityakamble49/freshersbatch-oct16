import java.io.FileNotFoundException;
import java.io.IOException;

public class TryTypes {

    public static void main(String[] args) {

        try {

            // this
            try {
                // this
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            throw new IOException();
        } catch (IOException e) {

        } finally {
            // do this finally
        }
    }
}
