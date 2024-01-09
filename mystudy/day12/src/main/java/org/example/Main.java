package org.example;

import org.example.entity.User;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("张一");
        user.setAge(12);
        user.setWeekDay(WeekDay.Firday);
        System.out.println(user.getWeekDay().getKey());
        switch (user.getWeekDay()) {
            case Monday:
                System.out.println(user.getName() + "在周一休息");
                break;
            case Tuesday:
                System.out.println(user.getName() + "在周二休息");
                break;
            case Wednesday:
                System.out.println(user.getName() + "在周三休息");
                break;
            case Thursday:
                System.out.println(user.getName() + "在周四休息");
                break;
            case Firday:
                System.out.println(user.getName() + "在周五休息");
                break;
            case Saturday:
                System.out.println(user.getName() + "在周六休息");
                break;
            case Sunday:
                System.out.println(user.getName() + "在周日休息");
                break;
        }

    }
}