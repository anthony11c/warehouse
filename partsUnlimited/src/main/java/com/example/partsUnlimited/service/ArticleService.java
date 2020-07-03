package com.example.partsUnlimited.service;

import com.example.partsUnlimited.dao.ArticleDAO;
import com.example.partsUnlimited.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleDAO articleDAO;

    @Autowired
    public ArticleService(@Qualifier("postgres") ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }


    public int addArticle(Article article){
        return articleDAO.insertArticle(article);
    }

    public List<Article> getAllArticles(){
        return articleDAO.selectAllArticles();
    }

    public int deleteArticle(String articleSerialNum) {
            return articleDAO.deleteArticle(articleSerialNum);
    }

    /*public int updateArticle(BigDecimal priceArticle, String articleSerialNum){

    }*/
}
