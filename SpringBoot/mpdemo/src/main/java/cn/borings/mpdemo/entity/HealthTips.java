package cn.borings.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@TableName("tips")
public class HealthTips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    //类型,发布时间,内容,作者,浏览量..
    private String title;
    private String type;
    private String author;
    private String p_time;
    private String intro;
    private String content;
//    private int count;

    @Override
    public String toString() {
        return "HealthTips{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", author='" + author + '\'' +
                ", p_time='" + p_time + '\'' +
                ", intro='" + intro + '\'' +
                ", content='" + content + '\'' +
//                ", count='" + content + '\''+
                '}';
    }

    public int gettId() {
        return tid;
    }

    public void settId(int tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getP_time() {
        return p_time;
    }

    public void setP_time(String p_time) {
        this.p_time = p_time;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//        this.count = count;
//    }
}
