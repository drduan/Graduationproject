package com.example.xudong.myapplication.behavior;

/**
 * Created by xudong on 2017/1/15.
 */
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.xudong.myapplication.R;

/**
 * Created by SidHu on 2016/8/18.
 */
public class MoveWithHeadBehavior extends BaseBehavior{

    private int lastBottom = -1;

    public MoveWithHeadBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == R.id.rel_head1;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

//Log.d()
        if (lastBottom == -1) {
            lastBottom = dependency.getBottom()-300;
            Log.d("TAG",dependency.getBottom()-300+"");
        }

        if (dependency.getBottom()-300 != lastBottom) {

            int d = dependency.getBottom()-300-lastBottom;
            lastBottom = dependency.getBottom()-300;

            child.offsetTopAndBottom(d);
        }
        return super.onDependentViewChanged(parent, child, dependency);
    }
}