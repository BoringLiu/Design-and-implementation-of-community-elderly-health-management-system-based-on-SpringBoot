package cn.borings.mpdemo.mapper;

import cn.borings.mpdemo.entity.HealthInfo;
import cn.borings.mpdemo.entity.HealthTips;
import cn.borings.mpdemo.entity.Order;
import cn.borings.mpdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HealthinfoMapper {
    @Select("select * from h_info where uid = #{uid}")
    HealthInfo selectHealthInfoByUid(int uid);//通过uid寻找个人信息

    @Select("select * from h_info")
    List<HealthInfo> selectAll();//查看所有

    @Insert("INSERT INTO h_info (uid,name,sex,birthday,using_medications,living_condition,allergic) VALUES (#{uid}, #{name}, #{sex}, #{birthday}, #{using_medications}, #{living_condition},#{allergic})")
    void createByUid(HealthInfo info);

    //通过个人健康情况来选择
}
