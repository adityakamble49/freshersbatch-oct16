package com.aditya.hibernate_chatting;

import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class DatabasePersistence implements Persistence {

    private SessionFactory sessionFactory;
    private Configuration configuration;
    private Chatroom currentChatroom;
    private User currentUser;

    public DatabasePersistence() {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
    }

    @Override
    public void openPersistence() {
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public void closePersistence() {
        sessionFactory.close();
    }

    @Override
    public void addChatroom(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Chatroom chatroom = new Chatroom(name);
        session.persist(chatroom);
        session.getTransaction().commit();
        session.close();
        System.out.println(name + " Chatroom added");
    }

    @Override
    public void deleteChatroom(String chatroomName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Chatroom.class);
        criteria.add(Restrictions.eq("name", chatroomName));
        Chatroom foundChatroom = (Chatroom) criteria.uniqueResult();

        if (foundChatroom != null) {
            session.delete(foundChatroom);
            System.out.println(chatroomName + " Deleted");
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void displayChatrooms() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Chatroom");
        List<Chatroom> chatroomList = query.list();
        for (Chatroom chatroom : chatroomList) {
            System.out.println(chatroom);
            for (User user : chatroom.getUserList()) {
                System.out.println(user);
            }
        }
        session.close();

    }

    @Override
    public void addUserToChatroom(String username, String password,
            String chatroomName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Chatroom.class);
        criteria.add(Restrictions.eq("name", chatroomName));
        Chatroom foundChatroom = (Chatroom) criteria.uniqueResult();

        if (foundChatroom != null) {
            User user = new User(username, password, foundChatroom);
            if (foundChatroom.getUserList() == null) {
                HashSet<User> users = new HashSet<User>();
                foundChatroom.setUserList(users);
            }

            foundChatroom.getUserList().add(user);
            System.out
                    .println(username + " added to " + foundChatroom.getName());

        } else {
            System.out.println(
                    "Add User failed : " + chatroomName + " not Exist");
        }
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void displayUsers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Chatroom.class);
        criteria.add(Restrictions.eq("name", currentChatroom.getName()));
        Chatroom foundChatroom = (Chatroom) criteria.uniqueResult();

        if (foundChatroom != null) {
            if (foundChatroom.getMessageList() == null) {
                System.out.println("No users");
            }

            foundChatroom.getUserList().forEach(System.out::println);
        } else {
            System.out.println("Failed to fetch users");
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUser(String username, String password) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        User foundUser = (User) criteria.uniqueResult();

        if (foundUser != null) {
            if (foundUser.getPassword().equals(password)) {
                session.delete(foundUser);
                System.out.println(username + " Deleted");
            } else {
                System.out.println("User Delete Failed : password invalid");
            }
        } else {
            System.out
                    .println("User Delete failed : " + username + " not Exist");
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void loginUser(String username, String password) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        User foundUser = (User) criteria.uniqueResult();

        if (foundUser != null) {
            if (foundUser.getPassword().equals(password)) {
                currentUser = foundUser;
                currentChatroom = foundUser.getChatroom();
                System.out.println(username + " Login Successful");
            } else {
                System.out.println("User Login Failed : password invalid");
            }
        } else {
            System.out
                    .println("User Login failed : " + username + " not Exist");
        }

        session.getTransaction().commit();
        session.close();
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
        currentUser = null;
        currentChatroom = null;
    }

    @Override
    public void sendMessage(String messageText) {
        String userMessage = currentUser.getUsername() + " : " + messageText;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Chatroom.class);
        criteria.add(Restrictions.eq("name", currentChatroom.getName()));
        Chatroom foundChatroom = (Chatroom) criteria.uniqueResult();

        if (foundChatroom != null) {
            if (foundChatroom.getMessageList() == null) {
                HashSet<Message> messages = new HashSet<Message>();
                foundChatroom.setMessageList(messages);
            }

            Message message = new Message(userMessage, foundChatroom);
            foundChatroom.getMessageList().add(message);
            System.out.println("Message Posted");

        } else {
            System.out.println("Failed to post message");
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void displayMessages() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Chatroom.class);
        criteria.add(Restrictions.eq("name", currentChatroom.getName()));
        Chatroom foundChatroom = (Chatroom) criteria.uniqueResult();

        if (foundChatroom != null) {
            if (foundChatroom.getMessageList() == null) {
                System.out.println("No Messages");
            }

            foundChatroom.getMessageList().forEach(m -> System.out.println(m));

        } else {
            System.out.println("Failed to fetch messages");
        }
        session.getTransaction().commit();
        session.close();
    }

}
