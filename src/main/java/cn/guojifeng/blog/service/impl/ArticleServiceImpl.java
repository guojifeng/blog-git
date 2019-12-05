package cn.guojifeng.blog.service.impl;

import cn.guojifeng.blog.domain.Article;
import cn.guojifeng.blog.domain.User;
import cn.guojifeng.blog.mapper.ArticleMapper;
import cn.guojifeng.blog.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void saveOrUpdate(Article article) {
        if (article.getId()==null){
            articleMapper.insert(article);
        }else {
            articleMapper.updateByPrimaryKey(article);
        }
    }

    @Override
    public List<Article> selectAll() {
        return articleMapper.selectAll();
    }

    @Override
    public Article getArticleById(int articleId) {
        return articleMapper.selectByPrimaryKey(articleId);
    }

    @Override
    public void deleteArticleById(int articleId) {
        articleMapper.deleteByPrimaryKey(articleId);
    }
}
