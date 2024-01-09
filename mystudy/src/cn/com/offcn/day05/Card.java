package cn.com.offcn.day05;

public class Card {
    private String uid = "";
    private String uname;
    private String password;
    private GenderEnum gender;
    private String openBank;
    private double money;

    public Card() {
    }

    public Card(String uid, String uname, String password, GenderEnum gender, String openBank, double money) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.gender = gender;
        this.openBank = openBank;
        this.money = money;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
