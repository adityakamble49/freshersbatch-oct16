import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadWriteFile {

    public static void main(String[] args) throws Exception {

        File readFile = new File("file1.txt");
        File writeFile = new File("file2.txt");

        FileInputStream fileInputStream = new FileInputStream(readFile);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        do {
            i = fileInputStream.read();
            if (i != -1) {
                sb.append((char) i);
            }
        } while (i != -1);
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(writeFile);
        fileOutputStream.write(sb.toString().getBytes());
        fileOutputStream.close();
    }
}
