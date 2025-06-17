package cn.borings.mpdemo.entity;


import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@TableName("service_info")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gid;
    private String name;

    private String intro;

    private double price;

    private int cond;

    @Override
    public String toString() {
        return "Services{" +
                "gid=" + gid +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", price=" + price +
                ", cond=" + cond +
                '}';
    }

    public int getCond() {
        return cond;
    }

    public void setCond(int cond) {
        this.cond = cond;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
