package com.akademicu.myfirstapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.akademicu.myfirstapp.response.ArticleResponse;
import com.akademicu.myfirstapp.retrofit.ApiRequest;
import com.akademicu.myfirstapp.retrofit.RetrofitRequest;

import java.time.LocalDate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;





    public ArticleRepository(){
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getDachBordNews(){

        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getAllHeadLines()
                .enqueue(new Callback<ArticleResponse>() {
                    @Override
                    public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                        if(response.body() != null){
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ArticleResponse> call, Throwable throwable) {
                        data.setValue(null);
                    }
                });
        return data;
    }


}
