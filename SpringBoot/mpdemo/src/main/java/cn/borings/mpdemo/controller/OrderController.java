package cn.borings.mpdemo.controller;

//import cn.borings.mpdemo.Config.RedisUtil;
import cn.borings.mpdemo.entity.Order;
import cn.borings.mpdemo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;


    @GetMapping("/order/findAll")
    public List findAll(){

        List orders = orderMapper.selectAllOrders();
        return orders;
    }

//    @GetMapping("/order/findByStatus")
//    public List findByStatus(){
//        return orderMapper.selectOrdersByStatus();
//    }依据名称查询所有订单状态
    @GetMapping("/order/findByStatus")
    public List findByStatus(int status){
        return orderMapper.selectOrdersByStatus(status);
    }//选择状态查询

    @PostMapping("/order/create")
    public int create(Order n){
        n.setStatus(0);
        orderMapper.create(n);
        return 1;
    }
    @PostMapping("/order/delete")
    public int del(int oid){
        System.out.println(oid);
        if(orderMapper.selectorderByOid(oid) == null) return 0;
        orderMapper.delOrderByOid(oid);
        return 1;
    }
}
