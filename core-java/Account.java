public class Account {

    private int balance = 0;

    public void deposit(int amount){
        balance += amount;
    }

    public void withdraw(int amount){
        balance -= amount;
    }

    public void printBalance(){
        System.out.println("Account Balance : " + balance);
    }

    public static void main(String args[]){
        Account a1 = new Account();
        a1.printBalance();
        a1.deposit(1000);
        a1.printBalance();
        a1.withdraw(500);
        a1.printBalance();
    }
}
