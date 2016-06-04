package com.android.dongnan.androidapi.common;

/**
 * Created by dream on 16/6/4.
 * This class is used to create the common TAG to check the Log more easily.
 */
public class Logger {

    private static String TAG = "WDN";

    private Logger(){
        // Static Class, Not need this.
    }
    public static void v(String tag, String msg) {
        android.util.Log.v(getFormattedTag(tag), msg);
    }

    private static String getFormattedTag(String tag) {
        return TAG + "-" + tag;
    }
}
