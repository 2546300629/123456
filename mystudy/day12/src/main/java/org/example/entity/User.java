package org.example.entity;

import org.example.WeekDay;

public class User {
    private String name;
    private int age;
    private WeekDay weekDay;

    public User(String name, int age, WeekDay weekDay) {
        this.name = name;
        this.age = age;
        this.weekDay = weekDay;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }
}
