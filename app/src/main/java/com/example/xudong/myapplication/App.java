package com.example.xudong.myapplication;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

import cn.smssdk.SMSSDK;

//import org.litepal.LitePal;

/**
 * Created by liyu on 2016/11/2.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        LitePal.initialize(this);
        if (!BuildConfig.DEBUG) {
            AppExceptionHandler.getInstance().setCrashHanler(this);
        }

        SMSSDK.initSDK(this, "ed68736f30f3", "3a2e2b7392b2f6838f07540b38533e90");

    }

    public static Context getContext() {
        return mContext;
    }

}
