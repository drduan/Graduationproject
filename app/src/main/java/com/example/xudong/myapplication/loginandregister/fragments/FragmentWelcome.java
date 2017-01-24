package com.example.xudong.myapplication.loginandregister.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.xudong.myapplication.R;
import com.example.xudong.myapplication.base.BaseFragment;


/**
 * Created by lamine on 17/04/2016.
 */
  public class FragmentWelcome extends BaseFragment {

    public FragmentWelcome()
    {
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void lazyFetchData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_welcome;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedInstance)
    {
        final View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();


        Button btn_go_login = (Button)rootView.findViewById(R.id.button_go_login);
        btn_go_login.setTextColor(Color.WHITE);
        btn_go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transactionToFragment(new FragmentLogin());
            }
        });

        Button btn_go_register = (Button)rootView.findViewById(R.id.button_go_signup);
        btn_go_register.setTextColor(Color.WHITE);
        btn_go_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transactionToFragment(new FragmentRegister());
            }
        });

        return rootView;
    }

    public void transactionToFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fm = getFragmentManager();
        fm.beginTransaction()
//                .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit()
        ;

    }
}