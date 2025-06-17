package cn.borings.mpdemo.controller;

//import cn.borings.mpdemo.Config.RedisUtil;
import cn.borings.mpdemo.Service.CountService;
import cn.borings.mpdemo.Service.TextMoreAutoDecreaseService;
import cn.borings.mpdemo.entity.HealthTips;
import cn.borings.mpdemo.mapper.TipsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin

//@CrossOrigin(origins = "http://localhost:8848")
public class HealthTipsController {

    @Autowired
    private TipsMapper tipsMapper;
    @Autowired
    private CountService countService;

    @Autowired
    private TextMoreAutoDecreaseService textMoreAutoDecreaseService;

//    @Autowired
//    private TipsMapper.TipsRepository tipsRepository;

    @GetMapping("/tips/alltips")
    public List alltips(){
//        countService.incrementPageView("/tips/alltips");
        List<HealthTips> alltips = tipsMapper.Alltips();
        textMoreAutoDecreaseService.Decreaser(alltips);
        return alltips;
    }

    @PostMapping("/tips/addtips")
    public int addtips(@RequestBody HealthTips toadd){
        if(tipsMapper.findBytitle(toadd.getTitle()) != null) return 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        // 设置格式化后的日期时间字符串到 p_time 属性
        toadd.setP_time(formattedDateTime);
        tipsMapper.save(toadd);
        return 1;
    }

    @PostMapping("/tips/deletetips")
    public int deletetips(int tid){
        System.out.println(tid);
        if(tipsMapper.findById(tid) == null) return 0;
        tipsMapper.delete(tid);
        return 1;
    }

    @GetMapping("/tips/findById")
    public HealthTips findById(int tid){
        return tipsMapper.findById(tid);
    }

}
