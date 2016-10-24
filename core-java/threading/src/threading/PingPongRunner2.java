package threading;

public class PingPongRunner2 extends Thread {

    public PingPongRunner2(String name) {
        this.setName(name);

    }

    public static void main(String[] args) {

        Thread t1 = new PingPongRunner2("PING");
        Thread t2 = new PingPongRunner2("PONG");
        Thread t3 = new PingPongRunner2("TONG");

        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {

        if (this.getName().equals("PING")) {
            for (int i = 0; i < 10; i++) {
                System.out.println("PING");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else if (this.getName().equals("PONG")) {
            for (int i = 0; i < 10; i++) {
                System.out.println("\tPONG");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else if (this.getName().equals("TONG")) {
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
