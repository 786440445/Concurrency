package concurrency;

import java.lang.management.RuntimeMXBean;

import static java.lang.Thread.sleep;

public class DieLockDemo {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            synchronized(lock1){
                try {
                    System.out.println("已获取lock1");
                    sleep(2000);
                    System.out.println("等待获取lock2");
                    synchronized (lock2){
                        System.out.println("lock1，2获取成功 end!");
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    static class Thread2 implements Runnable {
        @Override
        public void run() {
            synchronized(lock2){
                try {
                    System.out.println("已获取lock2");
                    sleep(2000);
                    System.out.println("等待获取lock1");
                    synchronized (lock1){
                        System.out.println("lock2，1获取成功 end!");
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }
}
