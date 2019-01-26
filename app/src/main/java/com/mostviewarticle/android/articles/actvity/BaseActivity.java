package com.mostviewarticle.android.articles.actvity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    public Activity context = this;
    public Handler handler;
    public boolean isBlocked = false;
    //public StorageUtils storage;
    // public AppStore appStore;

    AlertDialog loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler(Looper.getMainLooper());
        // storage = StorageUtils.getInstance(context);
        // appStore = AppStore.getInstance();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }

    abstract public void inits();

    abstract public void setEvents();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    public void Log(String tag, String value) {
        //  if (AppConstants.onTest) Log.e(tag, value);
    }

    public void makeConnectionToast() {
        Toast.makeText(context, "Request Failed, Please Check Internet Connection !", Toast.LENGTH_SHORT).show();
    }

    public void makeToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void makeToastLong(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
