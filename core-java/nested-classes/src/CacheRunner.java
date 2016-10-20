import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

public class CacheRunner {
    public static void main(String[] args) {
        App.addCache("Hello");
        App.addCache("Aditya");
        App.addCache("Kamble");

        System.out.println(App.getCache(0));
        System.out.println(App.getCache(1));
        System.out.println(App.getCache(2));
    }
}

class App {

    private static class Cache {

        static {
            cacheStorage = new HashMap<Integer, String>();
        }

        private static HashMap<Integer, String> cacheStorage;
        private static Timestamp timestamp;
        private static String data;
        private static int keyCounter = 0;

        public static void setData(String data) {
            timestamp = new Timestamp(new Date().getTime());
            data = data;
            cacheStorage.put(keyCounter, timestamp + " : " + data);
            keyCounter++;
        }

        public static String getData(Integer key) {
            return cacheStorage.get(key);
        }
    }

    public static void addCache(String data) {
        Cache.setData(data);
    }

    public static String getCache(Integer key) {
        return Cache.getData(key);
    }
}
