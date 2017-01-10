package com.example.xudong.myapplication.base;

import android.support.v4.widget.SwipeRefreshLayout;

import com.example.xudong.myapplication.R;
import com.example.xudong.myapplication.utils.ThemeUtil;


/**
 * Created by liyu on 2016/10/31.
 */

public abstract class BaseContentFragment extends BaseFragment {

    protected SwipeRefreshLayout refreshLayout;

    private void initRefreshLayout() {
//        refreshLayout = findView(R.id.swipe_container);
//        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                lazyFetchData();
//            }
//        });
//        refreshLayout.setColorSchemeResources(ThemeUtil.getCurrentColorPrimary(getActivity()));
    }

    @Override
    protected void initViews() {
        initRefreshLayout();
    }

    protected void showRefreshing(final boolean refresh) {
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(refresh);
            }
        });
    }
}
