package com.example.user.navigation_tab.application_utility;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by USER on 13-May-15.
 */
public class L extends Application{

    private static final String TAG = "Logger";

    public static void log(Context context, String msg)
    {
        Log.i(TAG, msg);
    }

    public static void log(Context context, String tag,String msg)
    {
        Log.i(tag, msg);
    }

    public static void LShow(Context context, String msg)
    {
        Log.i(TAG, msg);
    }

    public static void lshow(Context context, String msg)
    {
        Log.i(TAG, msg);
    }
}
