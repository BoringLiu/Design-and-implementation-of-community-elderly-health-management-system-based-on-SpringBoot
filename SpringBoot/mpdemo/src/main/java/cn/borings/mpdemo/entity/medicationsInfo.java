package cn.borings.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@TableName("medications")
public class medicationsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;
    private String name;
    private int count;
    private String ldate;

    @Override
    public String toString() {
        return "medicationsInfo{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", ldate='" + ldate + '\'' +
                '}';
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getLdate() {
        return ldate;
    }

    public void setLdate(String ldate) {
        this.ldate = ldate;
    }
}
