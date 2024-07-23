package com.akademicu.myfirstapp.model;

import com.google.gson.annotations.Expose;

public class Article {

    @Expose
    private String urlToImage;
    @Expose
    private String description;
    @Expose
    private String title;

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News by Akademicu{"+
                "urlToImage='"+urlToImage+
                "', description='"+description+
                "', title='"+title+"'}";
    }
}
