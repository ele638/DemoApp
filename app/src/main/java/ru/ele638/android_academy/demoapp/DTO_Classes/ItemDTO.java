package ru.ele638.android_academy.demoapp.DTO_Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDTO {

    @SerializedName("section")
    @Expose
    public String section;
    @SerializedName("subsection")
    @Expose
    public String subsection;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("abstract")
    @Expose
    public String _abstract;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("published_date")
    @Expose
    public String publishedDate;
    @SerializedName("multimedia")
    @Expose
    public List<ImageDTO> multimedia = null;
}
