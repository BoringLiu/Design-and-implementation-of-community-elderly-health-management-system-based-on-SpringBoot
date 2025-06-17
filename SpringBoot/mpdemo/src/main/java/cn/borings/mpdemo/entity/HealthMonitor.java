package cn.borings.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@TableName("h_monitor")
public class HealthMonitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //数据监测应导入一些专业的数据项，来假定一些老人定期在社区检查后的结果查看
    private String checkdate;
    private int steps;
    //血压高低
    private int xyh;
    private int xyl;
    private String eyes;
    private int avgheart;
    private String advice;

    @Override
    public String toString() {
        return "HealthMonitor{" +
                "id=" + id +
                ", steps=" + steps +
                ", checkdate='" + checkdate + '\'' +
                ", xyh=" + xyh +
                ", xyl=" + xyl +
                ", eyes=" + eyes +
                ", avgheart=" + avgheart +
                ", advice='" + advice + '\'' +
                '}';
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getXyh() {
        return xyh;
    }

    public void setXyh(int xyh) {
        this.xyh = xyh;
    }

    public int getXyl() {
        return xyl;
    }

    public void setXyl(int xyl) {
        this.xyl = xyl;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public int getAvgheart() {
        return avgheart;
    }

    public void setAvgheart(int avgheart) {
        this.avgheart = avgheart;
    }
    public String getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(String checkdate) {
        this.checkdate = checkdate;
    }

}
