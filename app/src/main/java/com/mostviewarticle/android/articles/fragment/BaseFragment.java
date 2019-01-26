package com.mostviewarticle.android.articles.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.mostviewarticle.android.articles.actvity.MainActivity;
import com.mostviewarticle.android.R;

public abstract class BaseFragment extends  Fragment {

    public Activity context;
    public Handler handler;
    private ProgressDialog dialog;
    // public StorageUtils storage;
    public ProgressDialog loader;
    public static String resourceString[];

    public MainActivity mainActivity;
    //public AppStore appStore;

    //private UserItem userItem;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        handler = new Handler(Looper.getMainLooper());
        //this.storage = getMainActivity().storage;
        // appStore = AppStore.getInstance();

        inits();
        setEvents();
    }



    public void showLoader() {
        if (loader == null) {
            loader = new ProgressDialog(context, R.style.MyDialogTheme);
            loader.setMessage("Please Wait.");
            loader.setCancelable(false);
        }
        loader.show();
    }

    public void hideLoader() {
        if (loader != null && loader.isShowing()) {
            loader.dismiss();
        }
    }

    public MainActivity getMainActivity() {

        if (mainActivity != null)
            return mainActivity;
        else {
            if (context instanceof MainActivity) {
                mainActivity = ((MainActivity) context);
            } else
                return null;
        }
        return mainActivity;
    }




    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        if (context == null)
            context = (Activity) activity;
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
    }




    abstract public void inits();

    abstract public void setEvents();


    public void Log(String tag, String value) {
        //if (AppConstants.onTest) Log.e(tag, value);
    }



    public void makeToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void makeToastLong(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
