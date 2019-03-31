package concurrency;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicDemo {
    // 原子更新数组
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static int[] value = new int[]{1, 2, 3};
    private static AtomicIntegerArray integerArray = new AtomicIntegerArray(value);

    // 原子更新引用类型
    private static AtomicReference<User> reference = new AtomicReference<>();


    // 原子更新字段类型
    private static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public static void main(String[] args) {
//        原子更新数组
//        System.out.println(atomicInteger.getAndIncrement());
//        System.out.println(atomicInteger.get());
//
//        int result = integerArray.getAndAdd(1, 5);
//        System.out.println(integerArray.get(1));
//        System.out.println(result);


//        原子更新引用类型
//        User user1 = new User("a", 1);
//        reference.set(user1);
//        User user2 = new User("b",2);
//        User user = reference.getAndSet(user2);
//        System.out.println(user);
//        System.out.println(reference.get());
        User user = new User("a", 1);
        int oldValue = updater.getAndAdd(user, 5);
        System.out.println(oldValue);
        System.out.println(updater.get(user));
    }
    static class User {
        private String userName;
        public volatile int age;

        public User(String userName, int age) {
            this.userName = userName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userName='" + userName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}