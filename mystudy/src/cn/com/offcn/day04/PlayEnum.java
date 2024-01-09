package cn.com.offcn.day04;

public enum PlayEnum {
    A("麦克",1),
    B("卡森",2);
    private String name;
    private int key;
    private PlayEnum(String name, int key) {
        this.name = name;
        this.key = key;
    }
}
