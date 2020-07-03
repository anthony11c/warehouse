package com.example.partsUnlimited.dao;

import com.example.partsUnlimited.model.Article;

import java.math.BigDecimal;
import java.util.List;

public interface ArticleDAO {

    int insertArticle(Article article);

    List<Article> selectAllArticles();

    int deleteArticle(String articleSerialNum);

    int updateArticle(BigDecimal priceArticle, String articleSerialNum);
}
