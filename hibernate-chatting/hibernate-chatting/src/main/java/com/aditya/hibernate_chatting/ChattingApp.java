package com.aditya.hibernate_chatting;

import java.util.Scanner;

public class ChattingApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Persistence persistence = new DatabasePersistence();
        persistence.openPersistence();

        int mainChoice = 1;

        while (mainChoice > 0) {

            System.out.println("Welcome TO Chatroom !");
            System.out.println("1. Create a chatroom\n" + "2. Add the user\n"
                    + "3. User login\n" + "4. Send a message\n"
                    + "5. Display the messages from a specific chatroom\n"
                    + "6. List down all users belonging to the specified chat room.\n"
                    + "7. Logout\n" + "8. Delete an user\n"
                    + "9. Delete the chat room : ");

            mainChoice = scanner.nextInt();

            switch (mainChoice) {

            // Create chat room
            case 1:
                System.out.println("Enter Chatroom Name : ");
                String chatroomName = scanner.next();
                persistence.addChatroom(chatroomName);
                break;

            // add user
            case 2:
                persistence.displayChatrooms();
                System.out.println("Chatroom Name : ");
                String userChatroom = scanner.next();
                System.out.println("Username : ");
                String userName = scanner.next();
                System.out.println("Password : ");
                String userPassword = scanner.next();
                persistence.addUserToChatroom(userName, userPassword,
                        userChatroom);
                break;

            // User Login
            case 3:
                if (!persistence.isOnline()) {
                    System.out.println("Enter Username & password : ");
                    String loginUsername = scanner.next();
                    String loginPassword = scanner.next();
                    persistence.loginUser(loginUsername, loginPassword);
                } else {
                    System.out.println("Logout First");
                }
                break;

            // Send Message
            case 4:
                if (persistence.isOnline()) {
                    System.out.println("Enter Message : ");
                    String message = scanner.next();
                    persistence.sendMessage(message);
                    persistence.displayMessages();
                } else {
                    System.out.println("Login First");
                }
                break;

            // display messages
            case 5:
                if (persistence.isOnline()) {
                    persistence.displayMessages();
                } else {
                    System.out.println("Login First");
                }
                break;

            // list all users
            case 6:
                if (persistence.isOnline()) {
                    persistence.displayUsers();
                } else {
                    System.out.println("Login First");
                }
                break;

            // logout
            case 7:
                if (persistence.isOnline()) {
                    persistence.logout();
                } else {
                    System.out.println("Login First");
                }
                break;

            // delete user
            case 8:
                System.out.println("Enter Username & password");
                String deleteUsername = scanner.next();
                String deletePassword = scanner.next();
                persistence.deleteUser(deleteUsername, deletePassword);
                break;

            // delete chatroom
            case 9:
                System.out.println("Enter Chatroom :");
                String deleteChatroomName = scanner.next();
                persistence.deleteChatroom(deleteChatroomName);
                break;

            default:
                break;
            }

        }

        persistence.closePersistence();
    }

}
