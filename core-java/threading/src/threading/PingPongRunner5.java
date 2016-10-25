package threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PingPongRunner5 {

    public static void main(String[] args) {

        Callable<Integer> c1 = new Callable<Integer>() {

            @Override
            public Integer call() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("PING");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                return null;

            }
        };

        Callable<Integer> c2 = new Callable<Integer>() {

            @Override
            public Integer call() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("\tPONG");
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };

        Callable<Integer> c3 = new Callable<Integer>() {

            @Override
            public Integer call() {
                for (;;) {
                    System.out.println("\t\tTONG");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(c1);
        executor.submit(c2);
        executor.submit(c3);
        executor.shutdown();
    }
}
