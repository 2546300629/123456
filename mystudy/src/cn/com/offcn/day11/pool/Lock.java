package cn.com.offcn.day11.pool;

public class Lock {
    private static Lock lock;

    private Lock() {

    }

    public static Lock getLock() {
        synchronized ("1") {
            if (lock == null) {
                lock = new Lock();
            }
        }
        return lock;
    }

}
