import java.io.File;
import java.text.SimpleDateFormat;

public class FileInfo {
    public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "MM/dd/yyyy HH:mm:ss");

        File file = new File("file1.txt");
        System.out.println("File Name : " + file.getName());
        System.out.println("File Size : " + file.length());
        System.out.println(
                "File Date : " + dateFormat.format(file.lastModified()));
        System.out.println("File Permission Read : " + file.canRead());
        System.out.println("File Permission Write : " + file.canWrite());
        System.out.println("File Permission Execute : " + file.canExecute());

        if (file.isFile())
            System.out.println("File Type : File");
        else if (file.isDirectory())
            System.out.println("File Type : Dir");
    }
}
