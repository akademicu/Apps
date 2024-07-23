package com.akademicu.myfirstapp.retrofit;

import static com.akademicu.myfirstapp.constants.AppConstant.API_KEY;

import com.akademicu.myfirstapp.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

    @GET("top-headlines?country=ro&category=entertainment&apiKey="+API_KEY)
    Call<ArticleResponse> getAllHeadLines();
}
