package concurrency;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2019/2/14.
 */
public class CreateThreadDemo {
    public static void main(String args[]) {
        // 1.继承Thread方法
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("继承Thread");
                super.run();
            }
        };
        thread.run();

        // 2.实现runnable接口
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现runable接口");
            }
        });
        thread1.start();

        // 3.实现callable接口
        ThreadDemo td = new ThreadDemo();
        FutureTask<String> task = new FutureTask<String>(td);
        new Thread(task).start();
        // 接收线程运算后的结果
        try {
            String result = task.get();  //FutureTask 可用于 闭锁 类似于CountDownLatch的作用，在所有的线程没有执行完成之后这里是不会执行的
            System.out.println(result);
            System.out.println("------------------------------------");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class ThreadDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "通过callable接口实现";
    }
}
