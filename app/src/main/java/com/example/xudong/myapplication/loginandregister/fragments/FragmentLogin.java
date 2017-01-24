package com.example.xudong.myapplication.loginandregister.fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xudong.myapplication.R;
import com.example.xudong.myapplication.ScrollingActivity;
import com.example.xudong.myapplication.base.BaseFragment;
import com.orhanobut.logger.Logger;


/**
 * Created by lamine on 17/04/2016.
 */
 public class FragmentLogin extends BaseFragment {

    public FragmentLogin()
    {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initViews() {




    }
/// 需要返回到上一个Fragment 用到fragment回退栈

    @Override
    protected void lazyFetchData() {


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedInstance)
    {
        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);


        Button btn =(Button)rootView.findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ScrollingActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });



        return rootView;
    }
}
