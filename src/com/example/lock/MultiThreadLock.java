package com.example.lock;

/**
 * @author Pengllrn
 * @since <pre>2019/9/5 19:59</pre>
 */
public class MultiThreadLock {
    private int count;
    private final Object lock = new Object();
    private volatile int state = 1;

    public MultiThreadLock(int count) {
        this.count = count;
    }

    public void future() throws InterruptedException {
        while (state <= count * 2) {
            synchronized (lock) {
                if (state > count * 2) break;
                if (state % 2 != 0)
                    lock.wait();
                System.out.print("Future");
                state++;
                lock.notifyAll();
            }
        }
    }

    public void dream() throws InterruptedException {
        while (state <= count * 2) {
            synchronized (lock) {
                if (state > count * 2) break;
                if (state % 2 != 1)
                    lock.wait();
                System.out.print("Dream");
                state++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadLock mtl = new MultiThreadLock(10);
        new Thread(() -> {
            try {
                mtl.future();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(100);

        new Thread(() -> {
            try {
                mtl.dream();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
