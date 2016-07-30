package com.forthorn.yan.itsme.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.forthorn.gen.bean.User;
import com.forthorn.gen.dao.DaoMaster;
import com.forthorn.gen.dao.DaoSession;
import com.forthorn.gen.dao.UserDao;
import com.forthorn.yan.itsme.MeApplication;
import com.forthorn.yan.itsme.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private EditText mEt_login_username;
    private EditText mEt_login_password;
    private Button mBtn_login_login;
    private TextView mTv_login_register;
    private ArrayList<User> mUsers;
    private MeApplication mMeApplication;
    private DaoSession mDaoSession;
    private SQLiteDatabase mUserDatabase;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Boolean mLogined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEt_login_username = (EditText) findViewById(R.id.et_login_username);
        mEt_login_password = (EditText) findViewById(R.id.et_login_password);
        mBtn_login_login = (Button) findViewById(R.id.btn_login_login);
        mTv_login_register = (TextView) findViewById(R.id.tv_login_register);
        mMeApplication = (MeApplication) getApplication();
        mUserDatabase = mMeApplication.getUserDatabase();
        mDaoSession = mMeApplication.getUserDaoSession();
        mSharedPreferences = getSharedPreferences("LoginStatus",MODE_PRIVATE);
        //
//        mLogined = mSharedPreferences.getBoolean("isLogin",false);
        mEditor = mSharedPreferences.edit();
        initEvent();



    }

    private void initEvent() {
        mBtn_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进行用户名及密码的匹配配对
                if (isAppUser()) {
                    mEditor.putBoolean("isLogin",true);
                    mEditor.commit();
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isAppUser() {
        if (TextUtils.isEmpty(mEt_login_username.getText()) || TextUtils.isEmpty(mEt_login_password.getText())) {
            Toast.makeText(LoginActivity.this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        String username = mEt_login_username.getText().toString().trim();
        String password = mEt_login_password.getText().toString().trim();
        String where = UserDao.Properties.Nickname + "=?";
        String[] argments = new String[]{username};
        //// TODO: 2016-07-22  存在问题 
        ArrayList<User> users = (ArrayList<User>) mDaoSession.getUserDao().queryRaw(where, argments);
        if (users.size() == 0) {
            Toast.makeText(LoginActivity.this, "用户名不存在", Toast.LENGTH_SHORT).show();
        } else if (users.get(0).getPassword().equals(password)) {
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            return true;
        }else {
            Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
            mEt_login_password.setText("");
        }
        return false;
    }

    public void register(View view) {

        Toast.makeText(LoginActivity.this, "注册", Toast.LENGTH_SHORT).show();
    }

}
