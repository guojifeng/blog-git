package cn.guojifeng.blog.controller;

import cn.guojifeng.blog.domain.User;
import cn.guojifeng.blog.service.IUserService;
import cn.guojifeng.blog.util.JwtUtil;
import cn.guojifeng.blog.util.PassToken;
import cn.guojifeng.blog.util.Result;
import cn.guojifeng.blog.util.UserLoginToken;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author 郭继峰
 * @Description  用户模块
 * @Date 2020/1/6 12:39
 **/
@Controller
@RequestMapping("/user")
@CrossOrigin
@Api("用户模块")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    private Logger logger = Logger.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value="/login")
    @PassToken
    public Result login(@RequestBody User user){
        User users = userService.checkUsernameAndPassword(user.getUsername(), user.getPassword());
//        Result result = new Result();
        if (users==null){
            return Result.createWithSuccessMessage("error");
        }
        String token = JwtUtil.getToken(users);
//      redisTemplate.opsForValue().set("zz","guojifeng");
        return Result.createWithModel("success",token);

    }


    @ResponseBody
    @RequestMapping(value="/test2")
    @PassToken
    public String test2(){
        List<User> users = userService.selectAll();
        logger.debug("------------debug------------------");
        logger.info("------------info------------------");
        logger.warn("------------warn------------------");
        logger.error("------------error------------------");
        logger.fatal("------------fatal------------------");
//        String token = JwtUtil.getToken(users.get(0));
//        String zz = (String) redisTemplate.opsForValue().get("zz");
//        System.out.println(zz);
        return "success";
    }

}
