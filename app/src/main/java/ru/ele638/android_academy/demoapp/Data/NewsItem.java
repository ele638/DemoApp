/*
 * *
 *  * Created by Mansur Biryukov on 9/30/18 3:53 AM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 9/30/18 3:53 AM
 *
 */

package ru.ele638.android_academy.demoapp.Data;

/**
 * Created by ele638 on 30/09/2018.
 * ele638@gmail.com
 */


import java.util.Date;

public class NewsItem {

    private final String title;
    private final String imageUrl;
    private final Category category;
    private final Date publishDate;
    private final String previewText;
    private final String fullText;

    public NewsItem(String title, String imageUrl, Category category, Date publishDate, String previewText, String fullText) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.category = category;
        this.publishDate = publishDate;
        this.previewText = previewText;
        this.fullText = fullText;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getPreviewText() {
        return previewText;
    }

    public String getFullText() {
        return fullText;
    }

}


