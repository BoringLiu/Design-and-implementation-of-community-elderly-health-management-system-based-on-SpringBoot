package cn.borings.mpdemo.mapper;

import cn.borings.mpdemo.entity.HealthMonitor;
import cn.borings.mpdemo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CheckMapper {
    @Select("select * from h_monitor where uid = #{uid}")
    HealthMonitor selectCheckByUid(int uid);
}
