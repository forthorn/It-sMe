package com.forthorn.yan.itsme;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.forthorn.gen.dao.DaoMaster;
import com.forthorn.gen.dao.DaoSession;

/**
 * Created by: Forthorn
 * Date: 2016-07-22.
 * Description:全局Application类
 */
public class MeApplication extends Application {
    public DaoSession mUserDaoSession;
    public SQLiteDatabase mUserDatabase;
    public DaoMaster mUserDaoMaster;
    public DaoMaster.DevOpenHelper mUserDevOpenHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化用户数据库
        setupUserDatabase();
    }

    private void setupUserDatabase() {
        //创建数据库
        // TODO: 2016-07-22 默认DaoMaster.DevOpenHelper在数据库升级时删除表，故应该再加一层封装
        mUserDevOpenHelper = new DaoMaster.DevOpenHelper(this,"user_db",null);
        //得到数据库连接对象
        mUserDatabase = mUserDevOpenHelper.getWritableDatabase();
        //获取数据库管理者
        mUserDaoMaster = new DaoMaster(mUserDatabase);
        //获取session对象，进行CRUD操作
        mUserDaoSession = mUserDaoMaster.newSession();
    }
    public DaoSession getUserDaoSession() {
        return mUserDaoSession;
    }
    public SQLiteDatabase getUserDatabase() {
        return mUserDatabase;
    }

}
