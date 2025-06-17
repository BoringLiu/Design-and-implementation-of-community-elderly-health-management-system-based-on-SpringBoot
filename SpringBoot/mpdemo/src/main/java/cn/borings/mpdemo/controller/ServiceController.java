package cn.borings.mpdemo.controller;


//import cn.borings.mpdemo.Config.RedisUtil;
import cn.borings.mpdemo.Service.CountService;
import cn.borings.mpdemo.entity.Order;
import cn.borings.mpdemo.entity.Services;
import cn.borings.mpdemo.entity.medicationsInfo;
import cn.borings.mpdemo.mapper.OrderMapper;
import cn.borings.mpdemo.mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
public class ServiceController {

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private CountService countService;
    @Autowired
    private OrderMapper orderMapper;


    @GetMapping("/service/all")
    public List<Services> findall(){
//        countService.incrementPageView("/service/all");
        return serviceMapper.selectAllService();
    }

    @GetMapping("/service/find")
    public Services find(String name){
//        countService.incrementPageView("/service/find");
        return serviceMapper.selectServiceByName(name);
    }

    @GetMapping("/service/book")
    public int book(int gid,int uid){
        Services s1 = serviceMapper.selectServiceByGid(gid);
        if(s1.getCond() == 0) return 0;
        Order n = new Order();
        n.setGid(gid);
        n.setOrdername(s1.getName());
        n.setTotal(s1.getPrice());
        n.setUid(uid);
        orderMapper.create(n);
//        orderMapper.createstatus(n.getOid());
        return 1;
    }
    @PostMapping("/service/newservice")
    public int newservice(@RequestBody Services n){
        System.out.println(n.getName());
        if(serviceMapper.selectServiceByName(n.getName()) != null) return 0;
        n.setCond(0);
        serviceMapper.newservice(n);
        return 1;
    }
    @PostMapping("/service/delservice")
    public int delservice(int gid){
        if(serviceMapper.selectServiceByGid(gid) == null) return 0;
        serviceMapper.delservice(gid);
        return 1;
    }
    @PostMapping("/service/chaservice")
    public int chaservice(int gid){
        Services n = serviceMapper.selectServiceByGid(gid);
        if(n == null) return 0;
        if(n.getCond() == 0){
            serviceMapper.setServiceCond(gid,1);
        }else{
            serviceMapper.setServiceCond(gid,0);
        }
        return 1;
    }




    @GetMapping("/service/store/medications")
    public List<medicationsInfo> allmed(){
        return serviceMapper.selectAllMed();
    }
    @PostMapping("/service/store/newmed")
    public int newmed(@RequestBody medicationsInfo n){
        if(serviceMapper.medbyname(n.getName()) != null) return 0;
        serviceMapper.newmed(n);
        return 1;
    }
    @PostMapping("/service/store/delmed")
    public int delmed(int mid){
        if(serviceMapper.medbyid(mid) == null) return 0;
        serviceMapper.delmed(mid);
        return 1;
    }
    @PostMapping("/service/store/chamed")
    public int chamed(int mid,int count){
        if(serviceMapper.medbyid(mid) == null) return 0;
        serviceMapper.chamed(mid,count);
        return 1;
    }
}
