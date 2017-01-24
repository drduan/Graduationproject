package com.example.xudong.myapplication.loginandregister.fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.xudong.myapplication.R;
import com.example.xudong.myapplication.base.BaseFragment;


/**
 * Created by lamine on 17/04/2016.
 */
public class FragmentRegister extends BaseFragment{

    public FragmentRegister()
    {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void lazyFetchData() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedInstance)
    {
        final View rootView = inflater.inflate(R.layout.fragment_register, container, false);


        return rootView;
    }
}

