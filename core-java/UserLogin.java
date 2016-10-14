import java.util.*;
public class UserLogin{
    public static void main(String args[]){

        Scanner scanner = new Scanner(System.in);

        int userAttemptsFailed = 0;
        String username = "aditya";
        String password = "adityapassword";


        while(userAttemptsFailed <3){

            System.out.println("Enter username and password");
            String loginUsername = scanner.next();
            String loginPassword = scanner.next();

            if(loginUsername.equals(username) && loginPassword.equals(password)){
                System.out.println("Welcome "+ username);
                return;
            }else{
                userAttemptsFailed++;
            }
        }

        System.out.println("Contact Admin");



    }
}
