package chat;

import java.util.ArrayList;
import java.util.List;

public class Chatroom {

    private String name;
    private List<User> userList;
    private List<Message> messageList;

    public Chatroom(String name) {
        this.name = name;
        userList = new ArrayList<User>();
        messageList = new ArrayList<Message>();
    }

    public String getName() {
        return name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void addMessage(Message message) {
        messageList.add(message);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (((Chatroom) o).getName().equals(this.getName())) {
            return true;
        }
        return false;
    }

}
