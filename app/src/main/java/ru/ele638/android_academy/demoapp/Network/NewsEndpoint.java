package ru.ele638.android_academy.demoapp.Network;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import ru.ele638.android_academy.demoapp.DTO_Classes.NewsDTO;

public interface NewsEndpoint {
    @GET("/svc/topstories/v2/home.json")
    Single<Response<NewsDTO>> getAllNews();

}
