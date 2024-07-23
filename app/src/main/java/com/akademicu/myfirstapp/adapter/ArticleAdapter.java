package com.akademicu.myfirstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.akademicu.myfirstapp.R;
import com.akademicu.myfirstapp.model.Article;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final Context context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newa_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = articleArrayList.get(position);
        holder.tvView.setText(article.getTitle());
        Glide.with(context)
                .load(article.getUrlToImage())
                .into(holder.imageViewCover);

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewCover;
        private final TextView tvView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewCover = itemView.findViewById(R.id.imageViewCover);
            tvView = itemView.findViewById(R.id.tvTitle);
        }
    }
}
