package com.example.xudong.myapplication.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by xudong on 2017/1/10.
 */

class ScrollviewListView extends ListView {

    public ScrollviewListView(Context context) {
        super(context);
    }

    public ScrollviewListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollviewListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,

                View.MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);

    }

}
