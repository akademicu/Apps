package com.akademicu.myfirstapp.view_model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.akademicu.myfirstapp.repository.ArticleRepository;
import com.akademicu.myfirstapp.response.ArticleResponse;

import org.jetbrains.annotations.NotNull;

public class ActivityViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    LiveData<ArticleResponse> articleResponseLiveData;

    public ActivityViewModel(@NotNull Application application) {
        super(application);
        articleRepository = new ArticleRepository();
        articleResponseLiveData = articleRepository.getDachBordNews();
    }

    public LiveData<ArticleResponse> getArticleResponseLiveData(){
        return articleResponseLiveData;
    }
}
