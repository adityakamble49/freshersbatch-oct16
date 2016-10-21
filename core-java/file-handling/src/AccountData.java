import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class AccountData {

    public static void main(String[] args) throws Exception {

        Account a1 = new Account(1, 3000.23, "ABC");
        Account a2 = new Account(2, 4040.43, "PRC");
        Account a3 = new Account(3, 6003.53, "GIC");

        File accountFile = new File("account.txt");
        FileOutputStream fos = new FileOutputStream(accountFile);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeInt(a1.getAccountNo());
        dos.writeDouble(a1.getBalance());
        dos.writeUTF(a1.getName());
        dos.writeInt(a2.getAccountNo());
        dos.writeDouble(a2.getBalance());
        dos.writeUTF(a2.getName());
        dos.writeInt(a3.getAccountNo());
        dos.writeDouble(a3.getBalance());
        dos.writeUTF(a3.getName());

        FileInputStream fis = new FileInputStream(accountFile);
        DataInputStream dis = new DataInputStream(fis);
        for (int i = 0; i < 3; i++) {
            System.out.println(dis.readInt() + " : " + dis.readDouble() + " : "
                    + dis.readUTF());
        }

    }
}

class Account {
    private int accountNo;
    private double balance;
    private String name;

    public Account(int accountNo, double balance, String name) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.name = name;
    }

    public int getAccountNo() {
        return accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
