package cn.borings.mpdemo.entity;


import com.baomidou.mybatisplus.annotation.TableName;

import javax.annotation.processing.Generated;
import javax.persistence.*;

@Table(name = "views_count")
@Entity
public class Views {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tid;
    private String url;
    private int views;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void settId(Long tid) {
        this.tid = tid;
    }

    public Long gettId() {
        return tid;
    }
}
