package ru.ele638.android_academy.demoapp.Network;

import java.io.IOException;

import io.reactivex.Single;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ele638.android_academy.demoapp.DTO_Classes.NewsDTO;

public class RestAPI {

    private final String URL = "https://api.nytimes.com/";
    private final String API_KEY = "dfe2cdf81a6a47449098cc73f312a9bf";

    private NewsEndpoint newsEndpoint;
    private static RestAPI instance;

    public static RestAPI getInstance(){
        if(instance == null){
            instance = new RestAPI();
        }
        return instance;
    }


    public RestAPI() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return chain.proceed(
                                chain.request()
                                    .newBuilder()
                                    .header("api-key", API_KEY)
                                    .build());
                    }
                })
                .addNetworkInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(NewsEndpoint.class);
        instance = this;
    }

    public NewsEndpoint getAllNews(){
        return newsEndpoint;
    }
}
