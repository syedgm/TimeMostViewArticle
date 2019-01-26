package com.mostviewarticle.android.articles.actvity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.mostviewarticle.android.R;

public abstract class BaseFragmentActivity extends BaseActivity {

    public Activity context = this;
    public Handler handler;
    public boolean isBlocked = false;
    //   public StorageUtils storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handler = new Handler(Looper.getMainLooper());
        //   storage = StorageUtils.getInstance(context);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void ReplaceFragment(Fragment fragment) {
        clearBackStack();
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        trans.replace(R.id.main_frame, fragment,fragment.getClass().getSimpleName());
        trans.commit();
    }

    public void clearBackStack() {
        //AppConstants.sDisableFragmentAnimations = true;
        getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        // AppConstants.sDisableFragmentAnimations = false;
    }





    public Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.main_frame);
    }








}

