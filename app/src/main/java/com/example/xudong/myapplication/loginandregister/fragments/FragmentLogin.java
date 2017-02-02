package com.example.xudong.myapplication.loginandregister.fragments;


import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xudong.myapplication.Main2Activity;
import com.example.xudong.myapplication.R;
import com.example.xudong.myapplication.ScrollingActivity;
import com.example.xudong.myapplication.base.BaseFragment;
import com.example.xudong.myapplication.utils.StringUtil;
import com.example.xudong.myapplication.utils.SystemUtil;
import com.example.xudong.myapplication.utils.ToastUtil;

import butterknife.Bind;
import butterknife.OnClick;
import butterknife.OnTextChanged;


/**
 * Created by lamine on 17/04/2016.
 */

 public class FragmentLogin extends BaseFragment {


    @Bind(R.id.et_user_account)
    EditText mEtAccount;

    @Bind(R.id.et_user_password)
    EditText mEtPassword;

    @Bind(R.id.iv_delete_account)
    ImageView mIvDeleteAccount;

    @Bind(R.id.iv_delete_password)
    ImageView mIvDeletePassword;

    @Bind(R.id.btn_login)
    Button mBtnLogin;

    @Bind(R.id.tv_forget_password)
    TextView mTvForgetPassword;

    @Bind(R.id.tv_go_to_register)
    TextView mTvGoToRegister;



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

    @OnTextChanged(R.id.et_user_account)
    public void onAccountTextChange(CharSequence s) {
        int visible = StringUtil.isEmpty(s.toString()) ? View.GONE : View.VISIBLE;
        mIvDeleteAccount.setVisibility(visible);
    }

    @OnTextChanged(R.id.et_user_password)
    public void onPasswordTextChange(CharSequence s) {
        int visible = StringUtil.isEmpty(s.toString()) ? View.GONE : View.VISIBLE;
        mIvDeletePassword.setVisibility(visible);
    }

    @OnClick({R.id.iv_delete_account, R.id.iv_delete_password, R.id.btn_login, R.id.tv_forget_password, R.id.tv_go_to_register})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.iv_delete_account:
                mEtAccount.setText("");
                break;
            case R.id.iv_delete_password:
                mEtPassword.setText("");
                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.tv_forget_password:
                ToastUtil.showToast("该功能还未开发");
                break;
            case R.id.tv_go_to_register:
             //   getCallbacks().showRegister();
                break;
        }
    }


    /**
     * 执行登录操作
     */
    private void login() {


        // 隐藏软键盘
        SystemUtil.hideKeyBoard(getActivity());

        // 验证用户名是否为空
        final String account = mEtAccount.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            ToastUtil.showToast(R.string.toast_error_empty_account);
            return;
        }
        // 验证密码是否为空
        final String password = mEtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            ToastUtil.showToast(R.string.toast_error_empty_password);
            return;
        }
        // 禁用登录按钮,避免重复点击
        mBtnLogin.setEnabled(false);
        // 显示提示对话框
        //// TODO: 2017/2/2
        //showLoading(R.string.label_being_something);

        Intent intent = new Intent(getActivity(), ScrollingActivity.class);
        startActivity(intent);
        getActivity().finish();



        // 发起登录的网络请求
       // getCallbacks().login(account, password);
    }



    //@Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle onSavedInstance)
//    {
      //  final View rootView = inflater.inflate(R.layout.fragment_login, container, false);


//        Button btn =(Button)rootView.findViewById(R.id.login);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), ScrollingActivity.class);
//                startActivity(intent);
//                getActivity().finish();
//            }
//        });



   //     return  null;
      //  return rootView;
 //   }
}
