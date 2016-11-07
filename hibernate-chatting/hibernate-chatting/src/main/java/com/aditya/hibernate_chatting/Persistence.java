package com.aditya.hibernate_chatting;

public interface Persistence {

    public void openPersistence();

    public void addChatroom(String name);

    public void deleteChatroom(String name);

    public void displayChatrooms();

    public void addUserToChatroom(String username, String password,
            String chatroom);

    public void displayUsers();

    public void deleteUser(String username, String password);

    public void loginUser(String username, String password);

    public boolean isOnline();

    public void logout();

    public void sendMessage(String messageText);

    public void displayMessages();

    public void closePersistence();
}
