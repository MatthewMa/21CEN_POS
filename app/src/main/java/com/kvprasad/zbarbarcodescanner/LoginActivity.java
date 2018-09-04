package com.kvprasad.zbarbarcodescanner;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.matthew.customviews.JellyInterpolator;
import com.matthew.tools.DialogTools;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mBtnLogin;
    private View progress;
    private View mInputLayout;
    private float mWidth, mHeight;
    private LinearLayout mName, mPsw;
    private EditText userNameEditText, passwordEditText;
    private CheckBox cb_remember;
    private SharedPreferences myPreferences;
    private static final String REMEMBER_ME = "REMEMBER_ME";
    private static final String USER_NAME = "USER_NAME";
    private static final String PASSWORD = "PASSWORD";
    private static final String REMEMBER_CHECKED = "REMEMBER_CHECKED";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mBtnLogin = (TextView) findViewById(R.id.main_btn_login);
        progress = findViewById(R.id.layout_progress);
        mInputLayout = findViewById(R.id.input_layout);
        mName = (LinearLayout) findViewById(R.id.input_layout_name);
        mPsw = (LinearLayout) findViewById(R.id.input_layout_psw);
        userNameEditText = (EditText) findViewById(R.id.et_username);
        passwordEditText = (EditText) findViewById(R.id.et_password);
        cb_remember = (CheckBox) findViewById(R.id.cb_remember);
        myPreferences = getSharedPreferences(REMEMBER_ME, Context.MODE_PRIVATE);
        cb_remember.setChecked(myPreferences.getBoolean(REMEMBER_CHECKED,false));
        if(cb_remember.isChecked()){
            userNameEditText.setText(myPreferences.getString(USER_NAME,""));
            passwordEditText.setText(myPreferences.getString(PASSWORD,""));
        }
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Calculate the login control width and height
        mWidth = mBtnLogin.getMeasuredWidth();
        mHeight = mBtnLogin.getMeasuredHeight();
        // Hidden the input
        mName.setVisibility(View.INVISIBLE);
        mPsw.setVisibility(View.INVISIBLE);
        mBtnLogin.setEnabled(false);
        inputAnimator(mInputLayout, mWidth, mHeight);
        String userName = userNameEditText.getText().toString().trim().toLowerCase();
        String password = passwordEditText.getText().toString().trim().toLowerCase();
        if(userName.isEmpty() || password.isEmpty()) {
            DialogTools.showSweetDialog(this, SweetAlertDialog
                    .ERROR_TYPE,"Empty information","Username or password cannot be empty!");
            return;
        }
        if(userName.equals("admin") && password.equals("admin")){
            // Superuser
            Constants.role = "super";
        } else if(userName.equals("employee") && password.equals("employee")) {
            // Employee
            Constants.role = "employee";
        } else{
            DialogTools.showSweetDialog(this, SweetAlertDialog
                    .ERROR_TYPE,"Login error","Username or password is not correct!");
            return;
        }
        // Save username and password
        if(cb_remember.isChecked()) {
            myPreferences.edit().putString(USER_NAME,userName).putString(PASSWORD,password)
                    .putBoolean(REMEMBER_CHECKED,true).commit();
        } else {
            myPreferences.edit().putString(USER_NAME,"").putString(PASSWORD,"")
                    .putBoolean(REMEMBER_CHECKED,false).commit();
        }
        recover();
        // Check WIFI Status
        Constants.wifiAddress = getlocalip();
        if(Constants.wifiAddress.isEmpty()){
            // No network connect
            DialogTools.showSweetDialog(this,SweetAlertDialog.ERROR_TYPE,"No Network","There " +
                    "is no WIFI connected, please connect your WIFI first!");
            return;
        }
        // Jump to main activity
        Intent mainIntent = new Intent(this,MainActivity.class);
        startActivity(mainIntent);
    }

    /**
     * Get WIFI IP address
     * @return
     */
    private String getlocalip(){
        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService
                (Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        int ipAddress = wifiInfo.getIpAddress();
        if(ipAddress==0)
            return "";
        return ((ipAddress & 0xff)+"."+(ipAddress>>8 & 0xff)+"."
                +(ipAddress>>16 & 0xff)+"."+(ipAddress>>24 & 0xff));
    }

    private void inputAnimator(final View view, float w, float h) {

        AnimatorSet set = new AnimatorSet();

        ValueAnimator animator = ValueAnimator.ofFloat(0, w);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (Float) animation.getAnimatedValue();
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view
                        .getLayoutParams();
                params.leftMargin = (int) value;
                params.rightMargin = (int) value;
                view.setLayoutParams(params);
            }
        });

        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mInputLayout,
                "scaleX", 1f, 0.5f);
        set.setDuration(300);
        set.setInterpolator(new AccelerateDecelerateInterpolator());
        set.playTogether(animator, animator2);
        set.start();
        set.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                progress.setVisibility(View.VISIBLE);
                progressAnimator(progress);
                mInputLayout.setVisibility(View.INVISIBLE);

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        recover();
                    }
                }, 600);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }
        });

    }

    private void progressAnimator(final View view) {
        PropertyValuesHolder animator = PropertyValuesHolder.ofFloat("scaleX",
                0.5f, 1f);
        PropertyValuesHolder animator2 = PropertyValuesHolder.ofFloat("scaleY",
                0.5f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofPropertyValuesHolder(view,
                animator, animator2);
        animator3.setDuration(300);
        animator3.setInterpolator(new JellyInterpolator());
        animator3.start();
    }

    private void recover() {
        progress.setVisibility(View.GONE);
        mInputLayout.setVisibility(View.VISIBLE);
        mName.setVisibility(View.VISIBLE);
        mPsw.setVisibility(View.VISIBLE);
        mBtnLogin.setEnabled(true);

        ViewGroup.MarginLayoutParams params = (MarginLayoutParams) mInputLayout.getLayoutParams();
        params.leftMargin = 0;
        params.rightMargin = 0;
        mInputLayout.setLayoutParams(params);


        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mInputLayout, "scaleX", 0.5f,1f );
        animator2.setDuration(300);
        animator2.setInterpolator(new AccelerateDecelerateInterpolator());
        animator2.start();
    }
}
