import java.io.File;
import java.io.FileInputStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceMultiple {

    public static void main(String[] args) throws Exception {

        File file1 = new File("sf1.txt");
        FileInputStream fis1 = new FileInputStream(file1);

        File file2 = new File("sf2.txt");
        FileInputStream fis2 = new FileInputStream(file2);

        File file3 = new File("sf3.txt");
        FileInputStream fis3 = new FileInputStream(file3);

        Vector v = new Vector();
        v.add(fis1);
        v.add(fis2);
        v.add(fis3);

        Enumeration e = v.elements();

        SequenceInputStream sis = new SequenceInputStream(e);

        int i = 0;
        while ((i = sis.read()) != -1) {
            System.out.print((char) i);
        }

        sis.close();
        fis1.close();
        fis2.close();
        fis3.close();
    }
}
