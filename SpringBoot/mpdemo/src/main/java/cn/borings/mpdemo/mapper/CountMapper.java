package cn.borings.mpdemo.mapper;

import cn.borings.mpdemo.entity.Views;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CountMapper {

    @Select("select * from views_count where tid = #{tid}")
    Views selectViewsByTid(int tid);//通过tid寻找Count

    @Select("select * from views_count where url = #{url}")
    Views selectViewsByUrl(String url);//通过url寻找Count


    @Select("select * from views_count")
    List<Views> selectViewsALl();
}
