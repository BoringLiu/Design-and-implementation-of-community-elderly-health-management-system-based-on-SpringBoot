package cn.borings.mpdemo.controller;

//import cn.borings.mpdemo.Config.RedisUtil;
import cn.borings.mpdemo.entity.History;
import cn.borings.mpdemo.mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class SickHistoryController {
    @Autowired
    private HistoryMapper historyMapper;


    @GetMapping("/user/historyAll")
    public List<History> findAllHistory() {
        return historyMapper.selectAllhistory();
    }
    @GetMapping("/user/addhistory")
    public void addHistory(History n) {
        historyMapper.create(n);
    }

    @GetMapping("/user/historyById")
    public List<History> findById(int uid){
        return historyMapper.selectHistoryByUid(uid);
    }

    @GetMapping("/user/historyBySname")//病名查看患者
    public List<History> findBySname(String sname){
        return historyMapper.selectHistoryBySname(sname);
    }
//    public List<History> findByName(String name){
//        return historyMapper.selectHistoryByName(name);
//    }
    @PostMapping("/user/deletehistory")
    public void deleteHistory(int ssid){
        historyMapper.delete(ssid);
        return;
    }
}
