package cn.borings.mpdemo.mapper;

import cn.borings.mpdemo.entity.HealthTips;
import cn.borings.mpdemo.entity.Order;
import cn.borings.mpdemo.entity.medicationsInfo;
import org.apache.ibatis.annotations.*;
import cn.borings.mpdemo.entity.Services;

import java.util.List;

@Mapper
public interface ServiceMapper {
    @Select("select * from service_info")
    List<Services> selectAllService();//查看全部服务种类

    @Select("select * from service_info where name LIKE CONCAT('%',#{name},'%')")
    Services selectServiceByName(String name);//通过模糊查找寻找服务


    @Select("select * from medications")
    List<medicationsInfo> selectAllMed();
    @Select("select * from medications where name = #{name}")
    medicationsInfo medbyname(String name);
    @Select("select * from medications where mid = #{mid}")
    medicationsInfo medbyid(int mid);
    @Insert("INSERT INTO medications (mid,name,count,ldate) VALUES (#{mid}, #{name}, #{count}, #{ldate})")
    void newmed(medicationsInfo n);
    @Update("UPDATE medications SET count = #{count} WHERE mid = #{mid}")
    void chamed(int mid,int count);
    @Delete("DELETE FROM medications WHERE mid = #{mid}")
    void delmed(int mid);

    @Select("select * from service_info where gid = #{gid}")
    Services selectServiceByGid(int gid);

    @Insert("INSERT INTO service_info (gid,name,price,intro,cond) VALUES (#{gid}, #{name}, #{price}, #{intro},#{cond})")
    void newservice(Services n);

    @Delete("DELETE FROM service_info WHERE gid = #{gid}")
    void delservice(int gid);

    @Update("UPDATE service_info SET cond = #{i} WHERE gid = #{gid}")
    void setServiceCond(int gid, int i);
}
