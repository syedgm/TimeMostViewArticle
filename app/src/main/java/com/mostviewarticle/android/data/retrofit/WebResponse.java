package com.mostviewarticle.android.data.retrofit;


import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.mostviewarticle.android.util.Contract;

import java.util.ArrayList;
public class WebResponse<T> {
    @Nullable
    @Expose
    public  String status;
    @Nullable
    @Expose
    public ArrayList<Contract.mostViewArticle> results;


}