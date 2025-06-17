package cn.borings.mpdemo.entity;


import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@TableName("doctor_info")
public class doctorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;
    private String password;
    private String name;
    private String location;
    private String sex;
    private String condition;
    private String major;

    @Override
    public String toString() {
        return "doctorInfo{" +
                "did=" + did +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", sex='" + sex + '\'' +
                ", condition='" + condition + '\'' +
                ", major='" + major + '\'' +
                '}';
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
