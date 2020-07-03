package com.example.partsUnlimited.dao;

import com.example.partsUnlimited.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("action")
public class ActionDataAccessService implements ActionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ActionDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertAction(Action action) {
        String sql = "" +
                "INSERT INTO action(" +
                "date_start," +
                "date_end,)" +
                "discount," +
                "idArticle" +
                "VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                action.getDate_start(),
                action.getDate_end(),
                action.getDiscountPercentage(),
                action.getListOfDiscountedArticles());
    }
}
