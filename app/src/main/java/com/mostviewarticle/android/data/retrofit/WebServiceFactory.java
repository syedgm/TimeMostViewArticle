package com.mostviewarticle.android.data.retrofit;


import java.util.concurrent.TimeUnit;
import com.mostviewarticle.android.util.Contract;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WebServiceFactory {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        okhttp3.OkHttpClient.Builder httpClient = new okhttp3.OkHttpClient.Builder();
        httpClient.connectTimeout(20, TimeUnit.SECONDS);
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(Contract.ServerConstants.BASE_URL).client(httpClient.build()).build();


        return retrofit;
    }

}

