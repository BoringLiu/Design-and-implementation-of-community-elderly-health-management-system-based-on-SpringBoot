package cn.borings.mpdemo.mapper;


import cn.borings.mpdemo.entity.Order;
import cn.borings.mpdemo.entity.User;
import cn.borings.mpdemo.entity.medicationsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    @Select("select * from order_info where uid = #{uid}")
    List<Order> selectByUid(int uid);//通过uid寻找订单

    @Select("select * from order_info")
    List<Order> selectAllOrders();//寻找全部订单和全部用户

    @Select("select * from order_info where gid = #{gid}")
    List<Order> selectAllOrdersByGid();//依据订单产品查找全部订单


    @Select("SELECT order_info.oid, order_info.ordername, CASE WHEN order_status.oid IS NULL THEN '已完成' ELSE CASE WHEN order_status.status = 1 THEN '已下单' ELSE '服务中' END END AS order_status FROM order_info LEFT JOIN order_status ON order_info.oid = order_status.oid WHERE order_status.status = #{status};")
    List<Order> selectOrdersByStatus(int status);

    @Options(useGeneratedKeys = true, keyProperty = "oid")
    @Insert("INSERT INTO order_info (total,ordername,uid,gid) VALUES (#{total}, #{ordername}, #{uid}, #{gid})")
    void create(Order n);

//    @Insert("INSERT INTO order_status (oid,status) VALUES (#{oid}, 0)")
//    void createstatus(int oid);

    @Select("SELECT * from order_info where oid = #{oid}")
    Order selectorderByOid(int oid);

    @Delete("DELETE from order_info where oid = #{oid}")
    void delOrderByOid(int oid);
    //依据订单状态查找订单&区分订单产品方便分类
}

