package cn.borings.mpdemo.controller;

//import cn.borings.mpdemo.Config.RedisUtil;
import cn.borings.mpdemo.Service.CountService;
import cn.borings.mpdemo.entity.User;
import cn.borings.mpdemo.entity.doctorInfo;
import cn.borings.mpdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CountService countService;


    @GetMapping("/user/login")//登录信息校验
    public int login(@RequestParam String username,@RequestParam String password){
        User user = userMapper.selectByName(username);
        if(user == null) return 2;
        if(password.equals(user.getPassword())){
            return 1;
        }else{
            return 0;
        }
    }

    @GetMapping("/user/findAll")
    public List<User> find(){
        countService.incrementPageView("/user/findAll");
        return userMapper.selectAllUserAndOrders();
    }

    //条件查询
    @GetMapping("/user/find")
    public User findByName(@RequestParam String username){
        return userMapper.selectByName(username);
    }
    @GetMapping("/user/create")
    public int createByUid(@RequestBody User user){
        int uid = user.getId();
        if(userMapper.selectById(uid).getUsername() != null){
            return 0;
        }
        userMapper.createByUid(user);
        return 1;
    }

    @GetMapping("/user/delete")
    public int  deleteByUid(@RequestParam int uid){
        if(userMapper.selectById(uid).getUsername() != null){
            return 0;
        }
        userMapper.deleteByUid(uid);
        return 1;
    }

    @GetMapping("/user/change")
    public int changByUid(@RequestBody User user){
        int uid = user.getId();
        if(userMapper.selectById(uid).getUsername() != null){
            return 0;
        }
        userMapper.deleteByUid(uid);
        userMapper.createByUid(user);
        return 1;
    }


    //分页查询
    @GetMapping("/user/findByPage")
    public IPage findByPage(){

        Page<User> page = new Page<>(0,3);
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }

    @GetMapping("/user")
    public String query(){

        List<User> list = userMapper.selectList(null);
        System.out.println(list);
        return list.toString();
    }

    @PostMapping("/user")
    public  String save(User user){

        int i = userMapper.insert(user);
        System.out.println(user);

        if(i > 0){
            return "insert succeed";
        }else{
            return  "insert failed";
        }
    }
    @GetMapping("/user/doctorinfo")
    public List<doctorInfo> alldoctor(){
        return userMapper.selectAlldoctors();
    }
    @GetMapping("/user/chadoctorcond")
    public int alldoctor(int did){
        doctorInfo n = userMapper.selectDoctorsBydid(did);
        if(n == null) return 0;
        if(n.getCondition().equals("free")){
            userMapper.chacond(did,"unfree");
        }else{
            userMapper.chacond(did,"free");
        }
        return 1;
    }
}
