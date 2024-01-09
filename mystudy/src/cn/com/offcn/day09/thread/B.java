package cn.com.offcn.day09.thread;

public class B extends Thread{

    public void run(){
        for(int i=1;i<=300;i++){
            System.out.println("B<<<"+i);

        }
    }
}
