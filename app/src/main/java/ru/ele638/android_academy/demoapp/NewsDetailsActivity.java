/*
 * *
 *  * Created by Mansur Biryukov on 10/1/18 2:47 AM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 10/1/18 2:47 AM
 *
 */

package ru.ele638.android_academy.demoapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class NewsDetailsActivity extends AppCompatActivity {

    ImageView image;
    TextView caption, body, dateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        Toolbar toolbar = findViewById(R.id.newsDetailToolbar);
        setSupportActionBar(toolbar);


        supportPostponeEnterTransition();
        image = findViewById(R.id.newsDetailImage);
        caption = findViewById(R.id.newsDetailCaption);
        body = findViewById(R.id.newsDetailBody);
        dateTime = findViewById(R.id.newsDetailDateTime);

        getSupportActionBar().setTitle(getIntent().getStringExtra("Category"));
        caption.setText(getIntent().getStringExtra("Caption"));
        body.setText(getIntent().getStringExtra("Body"));
        dateTime.setText(getIntent().getStringExtra("DateTime"));

        Glide.with(this)
                .load(getIntent().getStringExtra("ImageURL"))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }
                })
                .into(image);
    }
}
