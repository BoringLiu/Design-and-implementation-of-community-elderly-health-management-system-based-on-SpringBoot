package cn.borings.mpdemo.mapper;


import cn.borings.mpdemo.entity.HealthTips;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TipsMapper extends BaseMapper<HealthTips> {

    //方法涵盖:全部文章，依据类型选择，依据简介选择，依据作者选择等
    @Select("select * from tips")
    @Results({
            @Result(column = "tid",property = "tid"),
            @Result(column = "title",property = "title"),
            @Result(column = "type",property = "type"),
            @Result(column = "author",property = "author"),
            @Result(column = "p_time",property = "p_time"),
            @Result(column = "intro",property = "intro"),
            @Result(column = "content",property = "content"),
//            @Result(column = "views",property = "count",javaType = Views.class,one = @One(select = "cn.borings.mpdemo.mapper.CountMapper.findByUrl"))

    })
    List<HealthTips> Alltips();

    @Insert("INSERT INTO tips (title, type, author, p_time, intro, content) VALUES (#{title}, #{type}, #{author}, #{p_time}, #{intro}, #{content})")
    void save(HealthTips healthTips);
    @Delete("DELETE from tips where tid = #{tid}")
    void delete(int tid);
    @Select("SELECT * FROM tips WHERE title = #{title}")
    HealthTips findBytitle(String title);

    @Select("SELECT * FROM tips WHERE tid = #{tid}")
    HealthTips findById(int tid);

//    @Repository
//    interface TipsRepository extends JpaRepository<HealthTips, Long> {
//
//    }
}

