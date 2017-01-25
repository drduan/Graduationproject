package com.example.xudong.myapplication;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

import com.baidu.location.service.LocationService;
import com.baidu.mapapi.SDKInitializer;

import org.litepal.LitePal;

import cn.smssdk.SMSSDK;

//import org.litepal.LitePal;

/**
 * Created by liyu on 2016/11/2.
 */

public class App extends Application {

    private static Context mContext;
    public LocationService locationService;
    public Vibrator mVibrator;


    @Override
    public void onCreate() {



        super.onCreate();
        mContext = getApplicationContext();

        LitePal.initialize(this);
        if (!BuildConfig.DEBUG) {
            AppExceptionHandler.getInstance().setCrashHanler(this);
        }

        SMSSDK.initSDK(this, "ed68736f30f3", "3a2e2b7392b2f6838f07540b38533e90");


        //初始化百度地图sdk
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());




    }

    public static Context getContext() {
        return mContext;
    }

}
