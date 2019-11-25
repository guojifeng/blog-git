package cn.guojifeng.blog.controller;

import cn.guojifeng.blog.domain.User;
import cn.guojifeng.blog.service.IUserService;
import cn.guojifeng.blog.util.JwtUtil;
import cn.guojifeng.blog.util.PassToken;
import cn.guojifeng.blog.util.Result;
import cn.guojifeng.blog.util.UserLoginToken;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @PassToken
    public Result login(@RequestBody User user){
        User users = userService.checkUsernameAndPassword(user.getUsername(), user.getPassword());
        Result result = new Result();
        if (users==null){
            result.setMessage("error");
            return result;
        }
        result.setMessage("success");
        String token = JwtUtil.getToken(users);
        result.setData(token);
//      redisTemplate.opsForValue().set("zz","guojifeng");
        return result;
    }


    @ResponseBody
    @RequestMapping(value="/test2")
    @UserLoginToken
    public String test2(){
        List<User> users = userService.selectAll();
//        String token = JwtUtil.getToken(users.get(0));
//        String zz = (String) redisTemplate.opsForValue().get("zz");
//        System.out.println(zz);
        return "success";
    }

}
