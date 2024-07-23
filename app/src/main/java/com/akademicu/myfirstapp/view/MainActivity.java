package com.akademicu.myfirstapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akademicu.myfirstapp.R;
import com.akademicu.myfirstapp.adapter.ArticleAdapter;
import com.akademicu.myfirstapp.model.Article;
import com.akademicu.myfirstapp.view_model.ActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button to_countries;

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ActivityViewModel activityViewModel;
    private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getArticles();



    }
    public void goToCountries(View view){
        Intent intent = new Intent(MainActivity.this, CountriesActivity.class);
        startActivity(intent);
        finish();
    }

    private void getArticles() {
        activityViewModel.getArticleResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse!=null && articleResponse.getArticles()!=null && !articleResponse.getArticles().isEmpty()){
                progressBar.setVisibility(View.GONE);
                List<Article> articleList = articleResponse.getArticles();
                articleArrayList.addAll(articleList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void init(){
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycle_view);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);

        adapter = new ArticleAdapter(MainActivity.this, articleArrayList);
        recyclerView.setAdapter(adapter);
        activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel.class);
    }
}