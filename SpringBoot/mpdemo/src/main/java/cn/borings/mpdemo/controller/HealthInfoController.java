package cn.borings.mpdemo.controller;


//import cn.borings.mpdemo.Config.RedisUtil;
import cn.borings.mpdemo.entity.HealthInfo;
import cn.borings.mpdemo.entity.User;
import cn.borings.mpdemo.mapper.HealthinfoMapper;
import cn.borings.mpdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HealthInfoController {
    @Autowired
    private HealthinfoMapper healthinfoMapper;
    @Autowired
    private UserMapper userMapper;


    @GetMapping("/user/healthinfo")
    public HealthInfo findById(@RequestParam int uid){
        return healthinfoMapper.selectHealthInfoByUid(uid);
    }

    @GetMapping("/user/add")
    public int createByUid(@RequestBody HealthInfo Info){
        int uid = Info.getuId();
        if(healthinfoMapper.selectHealthInfoByUid(uid) != null){
            return 0;
        }
        healthinfoMapper.createByUid(Info);
        return 1;
    }

    @GetMapping("/user/Allusersinfo")
    public List findAll(){
        List<HealthInfo> res= healthinfoMapper.selectAll();
        for(HealthInfo single: res){
            single.old = single.getold();
        }
        return res;
    }
}
