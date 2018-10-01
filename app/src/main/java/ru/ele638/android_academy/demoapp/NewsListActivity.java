/*
 * *
 *  * Created by Mansur Biryukov on 9/30/18 3:04 AM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 9/30/18 3:04 AM
 *
 */

package ru.ele638.android_academy.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class NewsListActivity extends AppCompatActivity implements MyItemClickListner {

    RecyclerView recyclerView;
    MyAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbarNewsList);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.newsRV);
        adapter = new MyAdapter(this, this);
        layoutManager = new GridLayoutManager(this, getResources().getConfiguration().orientation);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.news_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutMenu:
                startActivity(new Intent(this, AboutActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(NewsItem item, ImageView imageView) {
        Intent intent = new Intent(this, NewsDetailsActivity.class);
        intent.putExtra("ImageURL", item.getImageUrl());
        intent.putExtra("Category", item.getCategory().getName());
        intent.putExtra("Caption", item.getTitle());
        intent.putExtra("Body", item.getFullText());
        intent.putExtra("DateTime", new SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(item.getPublishDate()));
        Pair<View, String> shared2 = new Pair<>((View) imageView, ViewCompat.getTransitionName(imageView));


        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this, imageView, ViewCompat.getTransitionName(imageView)
        );

        startActivity(intent, optionsCompat.toBundle());
    }
}
