package com.example.al;

/**
 * @author Pengllrn
 * @since <pre>2019/8/19 20:53</pre>
 */
public class TestThread {
    private static volatile int n = 1;
    private static volatile int state = 1;
    private static final TestThread tt = new TestThread();
    public static void main(String[] args) {
        Thread thread1 = new Thread1();
        thread1.setName("A");
        Thread thread2 = new Thread2();
        thread2.setName("B");
        Thread thread3 = new Thread3();
        thread3.setName("C");
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            while (n <= 1000){
                synchronized (tt){
                    if(n > 1000) return;
                    if (state != 1){
                        try {
                            tt.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + " : " + n++);
                        state = 2;
                        tt.notifyAll();
                    }
                }
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            while (n <= 1000){
                synchronized (tt){
                    if(n > 1000) return;
                    if (state != 2){
                        try {
                            tt.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + " : " + n++);
                        state = 3;
                        tt.notifyAll();
                    }
                }
            }
        }
    }

    private static class Thread3 extends Thread {
        @Override
        public void run() {
            while (n <= 1000){
                synchronized (tt){
                    if(n > 1000) return;
                    if (state != 3){
                        try {
                            tt.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println(Thread.currentThread().getName() + " : " + n++);
                        state = 1;
                        tt.notifyAll();
                    }
                }
            }
        }
    }
}
