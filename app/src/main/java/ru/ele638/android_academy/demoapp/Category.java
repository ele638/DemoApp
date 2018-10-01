/*
 * *
 *  * Created by Mansur Biryukov on 9/30/18 3:54 AM
 *  * Copyright (c) 2018 . All rights reserved.
 *  * Last modified 9/30/18 3:54 AM
 *
 */

package ru.ele638.android_academy.demoapp;

/**
 * Created by ele638 on 30/09/2018.
 * ele638@gmail.com
 */
public class Category {
    private final int id;
    private final String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}