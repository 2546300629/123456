package cn.com.offcn.day06;

public class Book {
    private String name;    //  书名
    private String auther;  //  作者
    private String  press;  //  出版社

    private String classify; //  分类

    /*
    * 中国标准书号由标识符ISBN和10位数字组成。
    * 10位数字又分为组号、出版者号、书名号、校验码囚部分。其格式为:ISBN X-XXXEXXXXX-X。*/
    private String bookNo;  //  书号
    private String msg; //  图书简介
    private double price;   //  价格

    public Book() {
    }

    public Book(String name, String auther, String press, String classify, String bookNo, String msg, double price) {
        this.name = name;
        this.auther = auther;
        this.press = press;
        this.classify = classify;
        this.bookNo = bookNo;
        this.msg = msg;
        this.price = price;
    }

    public Book(String name, String auther, String press, String bookNo, String msg, double price) {
        this.name = name;
        this.auther = auther;
        this.press = press;
        this.bookNo = bookNo;
        this.msg = msg;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
