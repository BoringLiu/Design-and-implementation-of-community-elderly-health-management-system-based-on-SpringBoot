package cn.borings.mpdemo.controller;


//import cn.borings.mpdemo.Config.RedisUtil;
import cn.borings.mpdemo.entity.HealthInfo;
import cn.borings.mpdemo.entity.HealthMonitor;
import cn.borings.mpdemo.mapper.CheckMapper;
import cn.borings.mpdemo.mapper.HealthinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HealthMonitorController {

    @Autowired
    private CheckMapper checkMapper;



    @GetMapping("/user/healthcheck")
    public HealthMonitor findById(@RequestParam int uid){
        return checkMapper.selectCheckByUid(uid);
    }

}
