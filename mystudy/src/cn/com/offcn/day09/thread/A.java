package cn.com.offcn.day09.thread;

public class A extends Thread{
    public void run(){  // 重写Thread类的run方法
        for(int i=1;i<=300;i++){
            System.out.println("A..."+i);

        }
    }
}