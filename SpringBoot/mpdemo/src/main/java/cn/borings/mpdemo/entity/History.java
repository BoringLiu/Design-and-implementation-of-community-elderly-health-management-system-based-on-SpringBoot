package cn.borings.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@TableName("history_info")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private int sid;
    private String sname;
    private String f_date;
    private String l_date;
    private String level;
    private int h_count;
    private int ssid;

    @Override
    public String toString() {
        return "History{" +
                "uid=" + uid +
                ", sid=" + sid +
                ", sname='" + sname + '\'' +
                ", f_date='" + f_date + '\'' +
                ", l_date='" + l_date + '\'' +
                ", level='" + level + '\'' +
                ", h_count=" + h_count +
                ", ssid=" + ssid +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getF_date() {
        return f_date;
    }

    public void setF_date(String f_date) {
        this.f_date = f_date;
    }

    public String getL_date() {
        return l_date;
    }

    public void setL_date(String l_date) {
        this.l_date = l_date;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getH_count() {
        return h_count;
    }

    public void setH_count(int h_count) {
        this.h_count = h_count;
    }

    public int getSsid() {
        return ssid;
    }

    public void setSsid(int ssid) {
        this.ssid = ssid;
    }
}
