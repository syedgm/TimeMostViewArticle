package com.mostviewarticle.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;


/**
 * Created by FP Danat on 2/4/2016.
 */
public class Utils {

    private static final String PREF_USER_SAVED = "prefs.userSaved";



    public static String getDeviceType(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getOsVersion() {
        return Build.VERSION.CODENAME;
    }





    public static String getDeviceVersion(Context context) {
        String version;
        try {
            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e1) {
            // TODO Auto-generated catch block
            version = "";
        }
        return version;
    }

    public static boolean isConnected(Context context) {

        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()){

            return true;
        }
        else {
             return false;
        }
    }



    public static boolean savelanguage(Context cntxt,String language) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(cntxt);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(CommoVariables.language, language);

        editor.commit();
        return true;
    }



        public static String getlanguage(Context context) {
            if (context == null) return null;
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);

            return pref.getString(CommoVariables.language, "");
        }

    public static boolean saveCurrency(Context cntxt,String currency) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(cntxt);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(CommoVariables.currency, currency);

        editor.commit();
        return true;
    }
















    }


