package com.aditya.hibernate_chatting;

public class PersistenceFactory {

    private static PersistenceFactory instance;

    private PersistenceFactory() {

    }

    public static PersistenceFactory getInstance() {
        if (instance == null) {
            instance = new PersistenceFactory();
        }
        return instance;
    }

    public Persistence getPersistence(PersistenceType persistenceType) {
        switch (persistenceType) {
        case MEMORY:
            return new MemoryPersistence();
        case DATABASE:
            return new DatabasePersistence();
        }
        return null;
    }
}
