package cn.borings.mpdemo.entity;

import cn.borings.mpdemo.mapper.OrderMapper;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@TableName("order_info")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;
    private int uid;
    private int gid;
    private String ordername;
    private double total;
    private String orderdate;
    private int status = 0;

//    @TableField(exist = false)
//    private User user;


    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", gid=" + gid +
                ", ordername='" + ordername + '\'' +
                ", total=" + total +
                ", orderdate='" + orderdate + '\'' +
                ", status=" + status +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
