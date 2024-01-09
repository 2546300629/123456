package org.example;

public enum WeekDay {
    Monday(1,"星期一"),Tuesday(2,"星期二"),Wednesday(3,"星期三"),
    Thursday(4,"星期四"),Firday(5,"星期五"),Saturday(6,"星期六"),
    Sunday(7,"星期日");

    private int key;
    private String value;

    WeekDay() {
    }

    WeekDay(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
