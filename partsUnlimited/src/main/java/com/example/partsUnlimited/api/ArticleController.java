package com.example.partsUnlimited.api;

import com.example.partsUnlimited.model.Article;
import com.example.partsUnlimited.model.Part;
import com.example.partsUnlimited.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("api/v1/sales")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public void addArticle(@RequestBody Article article){
        articleService.addArticle(article);
    }

    @GetMapping
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @DeleteMapping(path = "{articleSerialNum}")
    public void deletePartById(@PathVariable("articleSerialNum")String articleSerialNum) {
        articleService.deleteArticle(articleSerialNum);
    }

    /*@PutMapping(path = "{/update/{articleSerialNum}}")
    public void updateArticle(@PathVariable("price")BigDecimal priceArticle, @RequestBody Article article){
        articleService.updateArticle(priceArticle, article);
    }*/
}
