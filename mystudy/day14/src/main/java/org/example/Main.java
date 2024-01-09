package org.example;

import org.example.entity.Demo;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class demoClass = Demo.class;
//        Demo demo = demoClass.newInstance();
//        Method[] methods = demoClass.getMethods();
//        Constructor constructor = demoClass.getDeclaredConstructor();
//        constructor.setAccessible(true);    //  暴力使用private修饰的构造函数
//        Object o = constructor.newInstance();

        Field[] fields = demoClass.getFields(); //  获取所有public 修饰的字段
//        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = demoClass.getDeclaredFields(); //  获取所有字段，包括private修饰的字段
//        System.out.println(Arrays.toString(declaredFields));
        Field name = demoClass.getDeclaredField("name");    //  根据字段名获取指定字段，包括private修饰的字段
//        System.out.println(name);
        Method[] methods = demoClass.getMethods();  //  获取所有公开的方法，包括父类中的公开的方法
//        System.out.println(Arrays.toString(methods));

        Method test1 = demoClass.getMethod("test"); //  根据方法名获取指定的公开方法
//        System.out.println(test1);
        Method test11 = demoClass.getDeclaredMethod("test1");   //  根据方法名获取指定的方法，包括private修饰的方法
//        System.out.println(test11);

        Class returnType = test1.getReturnType();   //  获取方法的返回值的类型
        System.out.println(returnType);

        Method test2 = demoClass.getDeclaredMethod("test2", String.class);
        Type[] type = test2.getGenericParameterTypes(); //  获取方法的所有参数类型的值
        System.out.println(Arrays.toString(type));
        Constructor constructor = demoClass.getDeclaredConstructor();
        constructor.setAccessible(true);    //  暴力使用private修饰的构造函数
        Object o = constructor.newInstance();
        Demo demo = (Demo) o;
        test2.setAccessible(true);  //  暴力使用private修饰的方法
        test2.invoke(demo,"er");
    }
}