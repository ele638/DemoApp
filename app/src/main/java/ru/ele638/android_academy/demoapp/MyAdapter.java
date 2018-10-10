/*
 * *
 *  * Created by Mansur Biryukov on 9/30/18 3:57 AM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 9/30/18 3:57 AM
 *
 */

package ru.ele638.android_academy.demoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ele638 on 30/09/2018.
 * ele638@gmail.com
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<NewsItem> newsItems;
    private Context ctx;
    private MyItemClickListner myListener;

    MyAdapter(Context context, MyItemClickListner listener) {
        newsItems = DataUtils.generateNews();
        ctx = context;
        myListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(ctx)
                .inflate(R.layout.rv_row_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setItem(newsItems.get(position));
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView category, title, body, datetime;
        ImageView image;
        NewsItem item;

        MyViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.RVRowCategory);
            title = itemView.findViewById(R.id.RVRowTitle);
            body = itemView.findViewById(R.id.RVRowBody);
            datetime = itemView.findViewById(R.id.RVRowDateTime);
            image = itemView.findViewById(R.id.RVRowImage);
            itemView.setOnClickListener(this);
        }

        private void setItem(NewsItem setItem) {
            this.item = setItem;
            Glide.with(ctx)
                    .load(item.getImageUrl())
                    .into(image);
            category.setText(item.getCategory().getName());
            title.setText(item.getTitle());
            body.setText(item.getPreviewText());
            datetime.setText(new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(item.getPublishDate()));
        }

        @Override
        public void onClick(View v) {
            myListener.onClick(item, image);
        }
    }
}
