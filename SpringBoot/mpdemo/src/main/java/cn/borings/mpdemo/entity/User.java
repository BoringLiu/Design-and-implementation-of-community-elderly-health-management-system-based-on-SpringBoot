package cn.borings.mpdemo.entity;

import cn.borings.mpdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.lang.reflect.Type;
import java.util.List;

@TableName("user_info")
public class User {
    @TableId(type = IdType.AUTO)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String username;
    private String password;
    private String reg_date;
    private String address;
    private int phone;
    private String sex;
    private String condition;

    @TableField(exist = false)
    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    //all order of user

    @Override
    public String toString() {
        return "User{" +
                "id=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", reg_date='" + reg_date + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", sex='" + sex + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }

    public int getId() {
        return uid;
    }

    public void setId(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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
}
