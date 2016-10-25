package gaming;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaterTank3 extends Frame implements Runnable {

    int y = 200;
    int height = 200;

    Thread pourWater;
    Thread useWater;
    Thread controller;

    public int limit = 140;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();

    public WaterTank3() {
        super("Water Tank 2");
        setBackground(Color.CYAN);
        setSize(500, 500);
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        pourWater = new Thread(this);
        useWater = new Thread(this);

        pourWater.setName("PW");
        useWater.setName("UW");

        pourWater.start();
        useWater.start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(150, 100, 200, 300);
        g.setColor(Color.RED);
        g.fillRect(150, y, 200, height);
        g.drawString("70%", 380, 200);
    }

    @Override
    public void run() {

        Thread currentThread = Thread.currentThread();

        if (currentThread.getName().equals("PW")) {
            while (true) {

                if (y < limit) {
                    lock.lock();
                    try {
                        cond.await();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }

                y = y - 3;
                height = height + 3;
                repaint();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (currentThread.getName().equals("UW")) {
            while (true) {

                if (y > limit + 10) {
                    lock.lock();
                    try {
                        cond.signal();
                    } finally {
                        lock.unlock();
                    }
                }

                y = y + 3;
                height = height - 3;
                repaint();
                try {
                    Thread.sleep(280);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Frame mf = new WaterTank3();
        mf.setSize(500, 500);
        mf.setVisible(true);
    }

}
