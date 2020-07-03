package com.example.partsUnlimited.dao;

import com.example.partsUnlimited.model.Article;
import com.example.partsUnlimited.model.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository("postgres")
public class ArticleDataAccessService implements ArticleDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertArticle(Article article) {
        String sql = "" +
                "INSERT INTO article(" +
                "articleSerialNum," +
                "price)" +
                "VALUES (?, ?)";
        return jdbcTemplate.update(
                sql,
                article.getArticleSerialNum(),
                article.getPriceArticle());
    }

    @Override
    public List<Article> selectAllArticles() {
        String sql = "" +
                "SELECT articleSerialNum, price FROM article;";
        List<Article> articles = jdbcTemplate.query(sql, (resultSet, i) -> {
            String articleSerialNum = resultSet.getString("articleSerialNum");
            BigDecimal priceArticle = resultSet.getBigDecimal("price");
            return new Article(articleSerialNum, priceArticle);
        });
        return articles;
    }

    @Override
    public int deleteArticle(String articleSerialNum) {
        String sql = "" +
                "DELETE FROM article " +
                "WHERE articleSerialNum = ?";
        return jdbcTemplate.update(sql, articleSerialNum);
    }

    @Override
    public int updateArticle(BigDecimal priceArticle, String articleSerialNum) {
            String sql = "" +
                    "UPDATE article" +
                    "SET price = ?" +
                    "WHERE articleSerialNum = ?";
        return jdbcTemplate.update(sql, priceArticle, articleSerialNum);
    }
}
