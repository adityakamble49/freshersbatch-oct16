public class PersistenceRunner {

    public static void main(String[] args){

        Persistence[] persistenceArray = new Persistence[2];
        persistenceArray[0] = PersistenceFactory.getPersistence();
        persistenceArray[1] = PersistenceFactory.getPersistence();

        for (int i=0; i<persistenceArray.length; i++){
            persistenceArray[i].persist();
        }
    }
}

class PersistenceFactory {
    public static Persistence getPersistence(){
        return new DatabasePersistence();
    }
}

abstract class Persistence {
    public abstract void persist();
}

class DatabasePersistence extends Persistence {
    public void persist(){
        System.out.println("Datebase Persistence");
    }
}

class FilePersistence extends Persistence {
    public void persist(){
        System.out.println("File Persistence");
    }
}
