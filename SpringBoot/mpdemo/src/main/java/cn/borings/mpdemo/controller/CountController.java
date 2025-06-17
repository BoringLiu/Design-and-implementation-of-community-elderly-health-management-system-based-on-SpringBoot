package cn.borings.mpdemo.controller;

//import cn.borings.mpdemo.Config.RedisUtil;
import cn.borings.mpdemo.Service.CountService;
import cn.borings.mpdemo.entity.Views;
import cn.borings.mpdemo.mapper.CountMapper;
import cn.borings.mpdemo.mapper.CountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.View;
import java.util.List;

@RestController
@CrossOrigin
public class CountController {
    @Autowired
    private CountService countService;
    @Autowired
    private CountRepository countRepository;
    @Autowired
    private CountMapper countMapper;



    @GetMapping("/page")
    public String incrementPageView(String url) {//url查询
        countService.incrementPageView(url);
        return "Page view updated successfully";
    }

    @GetMapping("/pageAll")
    public List<Views> checkALlCount(){
        return countMapper.selectViewsALl();
    }

    @GetMapping("/pageurl")
    public Views checkCountByUrl(String url){
        return countMapper.selectViewsByUrl(url);
    }

    @GetMapping("/pageid")
    public Views checkCountById(int tid){
        return countMapper.selectViewsByTid(tid);
    }

}
