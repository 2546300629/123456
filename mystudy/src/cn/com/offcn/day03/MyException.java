package cn.com.offcn.day03;

public class MyException extends Exception{
    private String message;

    MyException(String msg) {
        this.message = "�ݲ�֧�����룺"+msg;
    }

    public String getMessage() {
        return message;
    }
}
