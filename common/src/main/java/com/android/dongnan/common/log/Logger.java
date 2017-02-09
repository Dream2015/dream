package com.android.dongnan.common.log;

import com.android.dongnan.common.BuildConfig;

/**
 * Created by dream on 2017/2/9.
 */

public class Logger {

    private static final String TAG = "dream-->";
    private static final boolean DEBUG_MODEL = BuildConfig.DEBUG_MODEL;

    public static void v(Class<?> classes, String msg) {
        android.util.Log.v(TAG + classes.getSimpleName(), msg);
    }
    
    public static void v(Class<?> classes, String msg, Throwable throwable) {
        android.util.Log.v(TAG + classes.getSimpleName(), msg, throwable);
    }

}
