package cn.guojifeng.blog.controller;


import cn.guojifeng.blog.domain.Article;
import cn.guojifeng.blog.domain.User;
import cn.guojifeng.blog.service.IArticleService;
import cn.guojifeng.blog.util.Result;
import cn.guojifeng.blog.util.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @ResponseBody
    @RequestMapping(value="/getAllArticle")
    public Result getAllArticle(){
        List<Article> articles = articleService.selectAll();
        return Result.createWithModel("success",articles);
    }

}
