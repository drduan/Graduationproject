package com.example.xudong.myapplication.behavior;

import android.support.v4.view.NestedScrollingChildHelper;
import android.view.View;

/**
 * Created by xudong on 2017/1/15.
 */

public class SelfNestedScrollingChildHelper extends NestedScrollingChildHelper {
    /**
     * Construct a new helper for a given view.
     *
     * @param view
     */
    public SelfNestedScrollingChildHelper(View view) {
        super(view);
    }
}
