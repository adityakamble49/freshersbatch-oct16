public class Bank {

    public static double getBankBalance(Account[] accArray){

        double bankBalance = 0;

        for(int i =0; i<accArray.length; i++){
            bankBalance += accArray[i].getTotalCash();
        }

        return bankBalance;
    }

    public static void main(String[] args){

        Account[] accArray = new Account[5];

        accArray[0] = new SavingAccount(1,1000,100);
        accArray[1] = new CurrentAccount(2,2000,100);
        accArray[2] = new SavingAccount(3,3000,100);
        accArray[3] = new CurrentAccount(4,4000,100);
        accArray[4] = new SavingAccount(5,5000,100);

        System.out.println("Bank Balance : " + getBankBalance(accArray));
    }
}

class Account {

    private int accountNumber;
    private double balance;

    public Account(int accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public double getTotalCash(){
        return balance;
    }
}
class SavingAccount extends Account {

    private double fixDeposite;

    public SavingAccount(int accountNumber, double balance,
            double fixDeposite){
        super(accountNumber, balance);
        this.fixDeposite = fixDeposite;
    }

    public double getTotalCash(){
        return super.getTotalCash() + fixDeposite;
    }
}

class CurrentAccount extends Account {

    private double cashCredit;

    public CurrentAccount(int accountNumber, double balance,
            double fixDeposite){
        super(accountNumber, balance);
        this.cashCredit = cashCredit;
    }

    public double getTotalCash(){
        return super.getTotalCash() - cashCredit;
    }
}
