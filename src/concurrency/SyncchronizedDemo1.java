package concurrency;

/**
 * Created by Administrator on 2019/2/16.
 */
public class SyncchronizedDemo1 {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }
}