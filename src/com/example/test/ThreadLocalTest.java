package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/8/7 15:19</pre>
 */
public class ThreadLocalTest {
    private static class Pair{
        int val;
        Pair(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }
    static ThreadLocal<Pair> local = new ThreadLocal<Pair>(){
        @Override
        protected Pair initialValue() {
            return new Pair(4);
        }
    };
    public static void main(String[] args) throws Exception{

        Pair pair = new Pair(2);
        local.set(pair);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Pair pair1 = local.get();
                System.out.println(pair1);
            }
        });
        thread1.start();
        Thread.sleep(100);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(local.get());
            }
        });
        Thread.sleep(100);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(local.get());
            }
        });
        thread2.start();
        System.gc();
        Thread.sleep(1000);
        thread3.start();
        System.out.println();
    }
}
