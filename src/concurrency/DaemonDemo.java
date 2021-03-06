package concurrency;

/**
 * Created by Administrator on 2019/2/14.
 */
public class DaemonDemo {
    public static void main(String[] args){
        Thread daemonThread = new Thread(()->{
            while(true){
                try{
                    System.out.println("i am alive");
                }finally {
                    System.out.println("finally block");
                }
            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();

        //确保main线程结束前能给daemonThread能够分到时间片
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
