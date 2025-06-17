package cn.borings.mpdemo.mapper;

import cn.borings.mpdemo.entity.HealthTips;
import cn.borings.mpdemo.entity.User;
import cn.borings.mpdemo.entity.doctorInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.*;

import java.io.Serializable;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
//
//    @Select("select * from user")
//    public List<User> find();
//
//    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
//    public int insert(User user);

    @Select("select * from user_info where uid = #{uid}")
    User selectById(int uid);

    @Select("select * from user_info where username = #{username}")
    User selectByName(String username);
    @Insert("INSERT INTO user_info (username,reg_date,password,address,phone, sex, condition) VALUES (#{username}, #{reg_date}, #{password}, #{address}, #{phone}, #{sex},#{condition})")
    void createByUid(User user);
    @Delete("DELETE * from user_info where uid = #{uid}")
    void deleteByUid(int uid);
    //User&Order
    @Select("select * from user_info")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "reg_date",property = "reg_date"),
            @Result(column = "id",property = "orders",javaType = List.class,
            many = @Many(select = "cn.borings.mpdemo.mapper.OrderMapper.selectByUid")
            )
    })
    List<User> selectAllUserAndOrders();

    @Select("select * from doctor_info")
    List<doctorInfo> selectAlldoctors();

    @Select("select * from doctor_info where did = #{did}")
    doctorInfo selectDoctorsBydid(int did);

    @Update("UPDATE doctor_info SET `condition` = #{cond} WHERE did = #{did}")
    void chacond(int did,String cond);
}
