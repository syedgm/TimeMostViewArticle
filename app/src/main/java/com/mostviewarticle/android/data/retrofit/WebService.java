package com.mostviewarticle.android.data.retrofit;


import com.mostviewarticle.android.util.Contract;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface WebService {


    @GET("v2/mostviewed/all-sections/7.json?api-key=gU6WrAg91HfGlqyUDAWo0N4lp0NF6z3p")
    Call<WebResponse<Contract.mostViewArticle>> mostViewHolder();


}

