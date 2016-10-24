package threading;

public class PingPongRunner implements Runnable {

    Thread t1, t2, t3;

    public PingPongRunner() {
        t1 = new Thread(this);
        t2 = new Thread(this);
        t3 = new Thread(this);

        t1.setName("PING");
        t2.setName("PONG");
        t3.setName("TONG");

        // t3.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();

    }

    public static void main(String[] args) {
        new PingPongRunner();
    }

    @Override
    public void run() {

        Thread thread = Thread.currentThread();

        if (thread.getName().equals("PING")) {
            for (int i = 0; i < 10; i++) {
                System.out.println("PING");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else if (thread.getName().equals("PONG")) {
            for (int i = 0; i < 10; i++) {
                System.out.println("\tPONG");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else if (thread.getName().equals("TONG")) {
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

    }
}
