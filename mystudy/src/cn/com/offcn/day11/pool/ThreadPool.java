package cn.com.offcn.day11.pool;

import cn.com.offcn.day09.thread.A;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static List<Integer> list = null;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        A a = new A();
        B b = new B();
        Thread ta = new Thread(a,"线程A");
        Thread tb = new Thread(b,"线程B");
        System.out.println(ta.getName() + "||" + tb.getName());
        pool.submit(ta);
        pool.submit(tb);

    }

    private static class A implements Runnable {
        @Override
        public void run() {
            synchronized (Lock.getLock()) {
                for (int i = 0; i < 300; i++) {
                    System.out.println(Thread.currentThread().getName()+"====="+i);
                }
            }
        }
    }

    private static class B implements Runnable{

        @Override
        public void run() {
            synchronized (Lock.getLock()) {
                for (int i = 300; i >= 0; i--) {
                    System.out.println(Thread.currentThread().getName()+"====="+i);
                }
            }
        }
    }
}
