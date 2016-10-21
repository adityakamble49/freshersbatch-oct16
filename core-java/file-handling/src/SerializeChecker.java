import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeChecker {
    public static void main(String[] args) throws Exception {

        File accountObjectFile = new File("account-object.txt");
        FileOutputStream fos = new FileOutputStream(accountObjectFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(new Account1(1, 2233.323, "ABC", new Date(1, 2, 1994)));
        oos.flush();
        oos.close();
        fos.flush();
        fos.close();
        System.out.println("Account Object Serialized");

        FileInputStream fis = new FileInputStream(accountObjectFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Account1 account1 = (Account1) ois.readObject();
        System.out.println(account1);

    }
}

class Account1 implements Serializable {
    private int accountNo;
    private transient double balance;
    private String name;
    private Date dob;
    private static final long serialVersionUID = 6l;

    public Account1(int accountNo, double balance, String name, Date dob) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.name = name;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return accountNo + " : " + balance + " : " + name + " : " + dob;
    }
}

class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}