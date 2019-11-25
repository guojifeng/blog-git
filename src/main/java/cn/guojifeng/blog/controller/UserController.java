package cn.guojifeng.blog.controller;

import cn.guojifeng.blog.domain.User;
import cn.guojifeng.blog.service.IUserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping(value="/login")
    public String login(@RequestBody User user){
        System.out.println(user);

        List<User> users = userService.selectAll();
        redisTemplate.opsForValue().set("zz","guojifeng");
        System.out.println("666");
        return "666";
    }


    @ResponseBody
    @RequestMapping(value="/test2")
    public String test2(){
        List<User> users = userService.selectAll();
        String zz = (String) redisTemplate.opsForValue().get("zz");
        System.out.println(zz);
        return zz;
    }

}
