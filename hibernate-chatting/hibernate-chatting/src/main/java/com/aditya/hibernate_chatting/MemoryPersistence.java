package com.aditya.hibernate_chatting;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MemoryPersistence implements Persistence {

    private Set<Chatroom> chatrooms;
    private User currentUser;
    private Chatroom currentChatroom;

    @Override
    public void openPersistence() {
        chatrooms = new HashSet<Chatroom>();
    }

    @Override
    public void addChatroom(String name) {
        if (chatrooms.contains(new Chatroom(name))) {
            System.out.println(name + " Chatroom Exists");
        } else {
            chatrooms.add(new Chatroom(name));
            System.out.println(name + " Chatroom Added");
        }
    }

    @Override
    public void deleteChatroom(String name) {
        chatrooms.removeIf(c -> c.getName().equals(name));
    }

    @Override
    public void displayChatrooms() {
        Iterator<Chatroom> chatroomIterator = chatrooms.iterator();
        while (chatroomIterator.hasNext()) {
            System.out.println(chatroomIterator.next());
        }
        System.out.println();
    }

    @Override
    public void addUserToChatroom(String username, String password,
            String chatroom) {

        for (Chatroom c : chatrooms) {
            if (c.getName().equals(chatroom)) {
                if (c.getUserList() == null) {
                    c.setUserList(new HashSet<User>());
                }
                for (User u : c.getUserList()) {
                    if (u.getUsername().equals(username)) {
                        System.out.println("User Already Exists");
                        return;
                    }
                }

                c.getUserList().add((new User(username, password, c)));
                System.out.println("User added");
            }
        }
    }

    @Override
    public void displayUsers() {
        for (Chatroom c : chatrooms) {
            if (c.getName().equals(currentChatroom.getName())) {
                for (User u : c.getUserList()) {
                    System.out.println(u);
                }
            }
        }
    }

    @Override
    public void deleteUser(String username, String password) {
        Iterator<User> userIterator = currentChatroom.getUserList().iterator();
        currentChatroom.getUserList()
                .removeIf(u -> u.getUsername().equals(username)
                        && u.getPassword().equals(password));
    }

    @Override
    public void loginUser(String username, String password) {
        for (Chatroom c : chatrooms) {
            for (User u : c.getUserList()) {
                if (u.getUsername().equals(username)
                        && u.getPassword().equals(password)) {
                    currentUser = u;
                    currentChatroom = c;
                }
            }
        }
    }

    @Override
    public boolean isOnline() {
        if (currentChatroom != null && currentUser != null) {
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        currentChatroom = null;
        currentUser = null;
    }

    @Override
    public void sendMessage(String messageText) {
        if (isOnline()) {
            String totalMessage = currentUser.getUsername() + " : "
                    + messageText;
            Message message = new Message(totalMessage, currentChatroom);
            if (currentChatroom.getMessageList() == null) {
                currentChatroom.setMessageList(new HashSet<Message>());
            }
            currentChatroom.getMessageList().add((message));
            System.out.println("Message Posted");
        } else {
            System.out.println("Offline");
        }
    }

    @Override
    public void displayMessages() {
        for (Message m : currentChatroom.getMessageList()) {
            System.out.println(m);
        }
    }

    @Override
    public void closePersistence() {

    }

}
