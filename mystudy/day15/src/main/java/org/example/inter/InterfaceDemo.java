package org.example.inter;

public interface InterfaceDemo {
    public default void test1() {
        System.out.println("我是接口的默认方法");
    }

    public abstract int test2(int a , int b);

    public static void test3() {
        System.out.println("我是接口的静态方法");
    }
}
