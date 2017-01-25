package com.example.xudong.myapplication.loginandregister.fragments;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.mapapi.map.Text;
import com.example.xudong.myapplication.R;
import com.example.xudong.myapplication.base.BaseFragment;
import com.orhanobut.logger.Logger;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


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


        Button reg_get_check_number = (Button)rootView.findViewById(R.id.reg_get_check_number);

        final TextView reg_phone = (TextView)rootView.findViewById(R.id.reg_phone);
        Button register_submit = (Button)rootView.findViewById(R.id.register_submit);
        final  EditText reg_check_number = (EditText)rootView.findViewById(R.id.reg_check_number);
        reg_get_check_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SMSSDK.getVerificationCode("86", reg_phone.getText().toString());//发送短信验证码到手机号  86表示的是中国
            }
        });


        SMSSDK.registerEventHandler(new EventHandler() {
            @Override
            public void afterEvent(int event, int result, Object data) {
                switch (event) {
                    case SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE:
                        if (result == SMSSDK.RESULT_COMPLETE) {
//                            KLog.e("验证成功");

                            Logger.d("验证成功");
                        } else {
//                            KLog.e("验证失败");
                            Logger.d("验证失败");

                        }
                        break;
                    case SMSSDK.EVENT_GET_VERIFICATION_CODE:
                        if (result == SMSSDK.RESULT_COMPLETE) {
//                            KLog.e("获取验证成功");
                            Logger.d("获取验证成功");

                        } else {
//                            KLog.e("获取验证失败");
                            Logger.d("获取验证失败");

                        }
                        break;
                }
            }
        });

        register_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SMSSDK.submitVerificationCode("86", reg_phone.getText().toString(),reg_check_number.getText().toString() );//提交验证码  在eventHandler里面查看验证结果

            }
        });


        return rootView;
    }
}

