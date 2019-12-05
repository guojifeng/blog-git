package cn.guojifeng.blog.service;

import cn.guojifeng.blog.domain.Article;
import cn.guojifeng.blog.domain.User;

import java.util.List;

public interface IArticleService {

    void saveOrUpdate(Article article);

    List<Article> selectAll();

    Article getArticleById(int articleId);

    void deleteArticleById(int articleId);


}
