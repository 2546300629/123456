package org.example.thread;

public class Test implements Runnable {
    private int t;

    public Test(int t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true) {
            synchronized ("0") {
                if (t == 0) {
                    System.out.println("票卖完了");
                    break;
                }
                System.out.println(Thread.currentThread().getName() +"卖出了一张票");
                System.out.println("还剩" + (--t)+"张票");
            }
        }
    }
}
