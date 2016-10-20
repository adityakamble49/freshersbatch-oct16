public class Account {

    private int balance = 0;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) throws InsufficientBalanceException {
        if (balance - amount < 0) {
            throw new InsufficientBalanceException(
                    "Balance is only : " + balance);
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return balance + "";
    }

    public static void main(String args[]) throws InsufficientBalanceException {
        Account a1 = new Account();
        System.out.println(a1);
        a1.deposit(1000);
        System.out.println(a1);
        a1.withdraw(500);
        System.out.println(a1);
        a1.withdraw(200);
        System.out.println(a1);
        a1.withdraw(500);
        System.out.println(a1);
    }
}
