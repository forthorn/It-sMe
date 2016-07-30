package com.forthorn.yan.itsme.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.forthorn.yan.itsme.R;

/**
 * Splash界面，初始化数据，进行登录验证判断，判断是否已经登录
 */
public class SplashActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private boolean mLogined;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSharedPreferences = getSharedPreferences("LoginStatus", MODE_PRIVATE);
        mLogined = mSharedPreferences.getBoolean("isLogin", false);
        ImageView imageView = (ImageView) findViewById(R.id.iv_splash);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F,0.5F,0.5F);
        scaleAnimation.setDuration(2500);
        imageView.startAnimation(scaleAnimation);
        new SplashHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!mLogined) {
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
            }
        }, 2500);
    }
    private class SplashHandler extends Handler {
    }
}
