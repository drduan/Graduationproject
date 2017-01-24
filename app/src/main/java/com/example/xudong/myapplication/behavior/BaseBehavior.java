package com.example.xudong.myapplication.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;

import com.example.xudong.myapplication.BehaviorContext;

/**
 * Created by xudong on 2017/1/15.
 */

public class BaseBehavior extends CoordinatorLayout.Behavior {

    public  static BehaviorContext behaviorcontext = new BehaviorContext();


    public BaseBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams params) {



        super.onAttachedToLayoutParams(params);
    }
}
