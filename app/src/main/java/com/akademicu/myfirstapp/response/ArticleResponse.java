package com.akademicu.myfirstapp.response;

import com.akademicu.myfirstapp.model.Article;
import com.google.gson.annotations.Expose;

import java.util.List;

public class ArticleResponse {

    @Expose
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "News by Akademicu{"+
                "articles="+articles+"}";
    }
}
