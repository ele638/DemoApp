package ru.ele638.android_academy.demoapp.DTO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageDTO {
    @SerializedName("url")
    @Expose
    public String url;
}
