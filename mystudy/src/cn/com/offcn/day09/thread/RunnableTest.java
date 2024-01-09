package cn.com.offcn.day09.thread;

public class RunnableTest {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
//        a.setPriority(Thread.MAX_PRIORITY);
        a.setDaemon(true);
        a.start();

        b.start();
        for(int i=1;i<=1000;i++){
            System.out.println("main..."+i);
            if(i%4==0){
                Thread.yield();
            }
        }

	/*	a.run();  // 方法调用，不能实现并发的效果
		b.run();
		*/
//        a.start();  // 启动线程A  ------> 线程启动后，自动会调用run方法
//        b.start();  // 启动线程B
    }
//    public static void main(String[] args) {
//        //创建自定义类对象  线程任务对象
//        MyRunnable mr = new MyRunnable();
//        //创建线程对象
//        Thread t = new Thread(mr, "小强");
//        t.start();
//        for (int i = 0; i < 20; i++) {
//            System.out.println("旺财 " + i);
//        }
//    }
}
