
public class InsufficientBalanceException extends Exception {
    private String message;

    public InsufficientBalanceException() {
    }

    public InsufficientBalanceException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Account has Insufficient Balance | " + message;
    }

}
