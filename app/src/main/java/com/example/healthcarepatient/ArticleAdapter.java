package com.example.healthcarepatient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcarepatient.data_models.Article;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    ArrayList<Article> articles;
    Context context;

    public ArticleAdapter(ArrayList<Article> articles,Context context) {
        this.articles = articles;
        this.context = context;
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.articles_item,parent,false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.article_image.setImageResource(articles.get(position).getDemoImage());
        holder.category_name.setText(articles.get(position).getCategoryName());
        holder.article_heading.setText(articles.get(position).getArticleHeading());
        holder.doctor_name.setText(articles.get(position).getDoctorName());
    }


    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        private TextView category_name,article_heading,doctor_name;
        ImageView article_image;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.textView_article_1);
            article_heading = itemView.findViewById(R.id.textView_article_2);
            doctor_name = itemView.findViewById(R.id.textView_article_3);
            article_image = itemView.findViewById(R.id.imageView_article);
        }
    }

    public static class Date {
    }
}
