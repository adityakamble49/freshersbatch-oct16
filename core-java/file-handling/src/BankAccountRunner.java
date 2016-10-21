import java.io.EOFException;
import java.io.File;
import java.io.RandomAccessFile;

public class BankAccountRunner {

    public static void main(String[] args) throws Exception {

        BankAccountManager bam = new BankAccountManager();
        bam.createAccount(1001, 3000.93, "Aditya");
        bam.createAccount(1002, 30000.93, "Akshay");
        bam.createAccount(1003, 10000.93, "Piyush");
        bam.readAccounts();
        System.out.println("High Paid :");
        bam.getHighPaid();
        bam.deleteAccount(1003);
        System.out.println();
        bam.readAccounts();
        bam.updateAccount(1002, 40000, "Akshay Chordiya");
        System.out.println();
        bam.readAccounts();

    }

}

class BankAccountManager {

    private File bankAccountBook;
    private RandomAccessFile ras;

    public BankAccountManager() throws Exception {

        bankAccountBook = new File("bank-account-book.dat");
        ras = new RandomAccessFile(bankAccountBook, "rw");
    }

    public void createAccount(int accountNo, double balnace, String name)
            throws Exception {
        ras.seek(ras.length());
        ras.writeInt(accountNo);
        ras.writeDouble(balnace);
        ras.writeUTF(name);
    }

    public void updateAccount(int accountNo, long balance, String name)
            throws Exception {

        ras.seek(0);
        while (ras.getFilePointer() < ras.length()) {
            long currentPointer = ras.getFilePointer();
            int currentAN = ras.readInt();
            ras.readDouble();
            try {
                ras.readUTF();
            } catch (EOFException e) {
            }
            if (currentAN == accountNo) {
                ras.seek(currentPointer);
                ras.writeInt(accountNo);
                ras.writeDouble(balance);
                ras.writeUTF(name);
            }
        }

        System.out.println("updated account " + accountNo);
    }

    public void deleteAccount(int accountNo) throws Exception {

        ras.seek(0);
        while (ras.getFilePointer() < ras.length()) {
            long currentPointer = ras.getFilePointer();
            int currentAN = ras.readInt();
            ras.readDouble();
            ras.readUTF();
            if (currentAN == accountNo) {
                ras.seek(currentPointer);
                ras.writeInt(0);
                ras.writeDouble(0);
                ras.writeUTF("          ");
            }
        }

        System.out.println("deleted account " + accountNo);
    }

    public void readAccounts() throws Exception {
        ras.seek(0);
        while (ras.getFilePointer() < ras.length()) {
            try {
                System.out.print(ras.readInt() + " " + ras.readDouble() + " "
                        + ras.readUTF());
            } catch (EOFException e) {
            }
            System.out.println();
        }
        System.out.println();
    }

    public void getHighPaid() throws Exception {

        ras.seek(0);
        while (ras.getFilePointer() < ras.length()) {
            long currentPointer = ras.getFilePointer();
            int currentAN = ras.readInt();
            double salary = ras.readDouble();
            String name = ras.readUTF();
            if (salary >= 10000) {
                System.out.println(currentAN + " " + salary + " " + name);
            }
        }
    }

}