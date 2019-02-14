package concurrency;

/**
 * Created by Administrator on 2019/2/14.
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException{
        //sleepThread睡眠1000ms
        final Thread sleepThread = new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                super.run();
            }
        };

        //busyThread
        Thread busyThread = new Thread(){
            @Override
            public void run(){
                while(true);
            }
        };
        sleepThread.start();
        busyThread.start();

        sleepThread.interrupt();
        busyThread.interrupt();
        while(sleepThread.isInterrupted());
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + busyThread.isInterrupted());
    }
}