package com.example.partsUnlimited.model;

import java.math.BigDecimal;
import java.util.List;

public class Action {
    String date_start;
    String date_end;
    Float discountPercentage;
    List <Article> listOfDiscountedArticles;

    public Action(String date_start, String date_end, Float discountPercentage, List<Article> listOfDiscountedArticles) {
        this.date_start = date_start;
        this.date_end = date_end;
        this.discountPercentage = discountPercentage;
        this.listOfDiscountedArticles = listOfDiscountedArticles;
    }

    public String getDate_start() {
        return date_start;
    }

    public String getDate_end() {
        return date_end;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public List<Article> getListOfDiscountedArticles() {
        return listOfDiscountedArticles;
    }
}
