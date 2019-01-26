package com.mostviewarticle.android.data.retrofit;

import com.google.gson.annotations.Expose;

/**
 * Created by rahmed on 12/7/2015.
 */
public class Paginate {

    @Expose
    public int totall;
    @Expose
    public int per_page;
    @Expose
    public int current_page;
    @Expose
    public int last_page;
    @Expose
    public int from;
    @Expose
    public int to;
}
