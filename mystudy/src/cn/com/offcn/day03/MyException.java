package cn.com.offcn.day03;

public class MyException extends Exception{
    private String message;

    MyException(String msg) {
        this.message = "暂不支持输入："+msg;
    }

    public String getMessage() {
        return message;
    }
}
