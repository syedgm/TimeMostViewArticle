package com.mostviewarticle.android.util;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class Contract {


    public static class ServerConstants {

        public static   String BASE_URL = "https://api.nytimes.com/svc/mostpopular/";
    }









    public class mostViewArticle{
        @Expose
        public  String title;
        @Expose
        public  String published_date;

        @Expose
        public  String source;
        @Expose
        public  String byline;

        @Expose @SerializedName("abstract")
        public  String abstracttxt;


        @Expose
        public ArrayList<Media> media;


    }
    public class Media{
        @Expose
        public String type;


        @Expose @SerializedName("media-metadata")
        public ArrayList<Mediametadata> mediametadata;
    }
    public class Mediametadata{
        @Expose
        public String url;
    }








}

