package org.example.impl;

import org.example.inter.InterfaceDemo;

public class ImplDaemo implements InterfaceDemo {


    public static void main(String[] args) {
        ImplDaemo impl = new ImplDaemo();
        impl.test1();
        impl.test2(2,4);
        InterfaceDemo.test3();
    }

    @Override
    public int test2(int a, int b) {
        return a+b;
    }
}
