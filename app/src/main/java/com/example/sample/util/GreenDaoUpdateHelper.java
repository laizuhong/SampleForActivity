package com.example.sample.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.sample.dao.BookBeanDao;
import com.example.sample.dao.DaoMaster;
import com.github.yuweiguocn.library.greendao.MigrationHelper;


/**
 * 作者：赖祖宏
 * 项目：qiniu
 * 时间：2017/7/17
 * 描述: 数据库升级辅助类，每添加一个表需要添加一个参数
 */

public class GreenDaoUpdateHelper extends DaoMaster.OpenHelper{
    public GreenDaoUpdateHelper(Context context, String name) {
        super(context, name);
    }

    public GreenDaoUpdateHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        MigrationHelper.migrate(db, BookBeanDao.class);
    }
}
