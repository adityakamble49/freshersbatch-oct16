package chat;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ChatRoomRunner {

    public static Set<Chatroom> chatrooms = new HashSet<Chatroom>();
    public static User currentUser;
    public static Chatroom currentChatroom;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome TO Chatroom !");
            System.out.println("1. Create a chatroom\n" + "2. Add the user\n"
                    + "3. User login\n" + "4. Send a message\n"
                    + "5. Display the messages from a specific chatroom\n"
                    + "6. List down all users belonging to the specified chat room.\n"
                    + "7. Logout\n" + "8. Delete an user\n"
                    + "9. Delete the chat room : ");

            int mainChoice = scanner.nextInt();

            switch (mainChoice) {

            // Create chat room
            case 1:
                System.out.println("Enter Chatroom Name : ");
                String chatroomName = scanner.next();
                addChatroom(chatroomName);
                displayChatrooms();
                break;

            // add user
            case 2:
                displayChatrooms();
                System.out.println("Select Chatroom : ");
                String userChatroom = scanner.next();
                System.out.println("Username : ");
                String userName = scanner.next();
                System.out.println("Password : ");
                String userPassword = scanner.next();
                addUserToChatroom(userName, userPassword, userChatroom);
                displayUsers(userChatroom);
                break;

            // User Login
            case 3:
                if (!isOnline()) {
                    System.out.println("Enter Username & password : ");
                    String loginUsername = scanner.next();
                    String loginPassword = scanner.next();
                    loginUser(loginUsername, loginPassword);
                } else {
                    System.out.println("Logout First");
                }
                break;

            // Send Message
            case 4:
                if (isOnline()) {
                    System.out.println("Enter Message : ");
                    String message = scanner.next();
                    sendMessages(message);
                    displayMessages();
                } else {
                    System.out.println("Login First");
                }
                break;

            // display messages
            case 5:
                if (isOnline()) {
                    displayMessages();
                } else {
                    System.out.println("Login First");
                }
                break;

            // list all users
            case 6:
                if (isOnline()) {
                    displayAllUsers();
                } else {
                    System.out.println("Login First");
                }

                // logout
            case 7:
                if (isOnline()) {
                    logout();
                } else {
                    System.out.println("Login First");
                }
                break;

            // delete user
            case 8:
                String deleteUsername = scanner.next();
                String deletePassword = scanner.next();
                deleteUser(deleteUsername, deletePassword);
                break;

            default:
                break;
            }
        }
    }

    public static boolean isOnline() {
        if (currentChatroom != null && currentUser != null) {
            return true;
        }
        return false;
    }

    public static boolean addChatroom(String chatroomName) {
        if (chatrooms.contains(new Chatroom(chatroomName))) {
            return false;
        } else {
            chatrooms.add(new Chatroom(chatroomName));
            return true;
        }
    }

    public static void addUserToChatroom(String username, String password,
            String chatroom) {

        for (Chatroom c : chatrooms) {
            if (c.getName().equals(chatroom)) {
                for (User u : c.getUserList()) {
                    if (u.getUsername().equals(username)) {
                        System.out.println("User Already Exists");
                        return;
                    }
                }

                c.addUser(new User(username, password));
                System.out.println("User added");
            }
        }
    }

    private static void loginUser(String loginUsername, String loginPassword) {
        for (Chatroom c : chatrooms) {
            for (User u : c.getUserList()) {
                if (u.getUsername().equals(loginUsername)
                        && u.getPassword().equals(loginPassword)) {
                    currentUser = u;
                    currentChatroom = c;
                }
            }
        }
    }

    private static void sendMessages(String messageText) {
        if (isOnline()) {
            String totalMessage = currentUser.getUsername() + " : "
                    + messageText;
            Message message = new Message(totalMessage);
            currentChatroom.addMessage(message);
            System.out.println("Message Posted");
        } else {
            System.out.println("Offline");
        }
    }

    private static void logout() {
        currentChatroom = null;
        currentUser = null;
    }

    private static void deleteUser(String deleteUsername,
            String deletePassword) {
        System.out.println("User Deleted");
    }

    public static void displayChatrooms() {
        Iterator<Chatroom> chatroomIterator = chatrooms.iterator();
        while (chatroomIterator.hasNext()) {
            System.out.println(chatroomIterator.next());
        }
        System.out.println();
    }

    public static void displayUsers(String chatroom) {
        for (Chatroom c : chatrooms) {
            if (c.getName().equals(chatroom)) {
                for (User u : c.getUserList()) {
                    System.out.println(u);
                }
            }
        }
    }

    public static void displayMessages() {
        for (Message m : currentChatroom.getMessageList()) {
            System.out.println(m);
        }

    }

    private static void displayAllUsers() {
        for (User u : currentChatroom.getUserList()) {
            System.out.println(u);
        }
    }
}
