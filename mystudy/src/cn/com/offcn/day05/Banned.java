package cn.com.offcn.day05;

import java.util.Calendar;
import java.util.Date;

public class Banned {
    private String uid;
    private Calendar time;

    public Banned(String uid, Calendar time) {
        this.uid = uid;
        this.time = time;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }
}
