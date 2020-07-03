package com.example.partsUnlimited.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Article {
    String articleSerialNum;
    BigDecimal priceArticle;

    public Article(@JsonProperty("articleSerialNum") String articleSerialNum,@JsonProperty("priceArticle") BigDecimal priceArticle) {
        this.articleSerialNum = articleSerialNum;
        this.priceArticle = priceArticle;
    }

    public String getArticleSerialNum() {
        return articleSerialNum;
    }

    public BigDecimal getPriceArticle() {
        return priceArticle;
    }
}
