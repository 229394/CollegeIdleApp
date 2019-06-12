package com.leaf.collegeidleapp.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.leaf.collegeidleapp.bean.User;

import java.util.LinkedList;

/**
 * 用户数据库连接类
 * @author : autumn_leaf
 */
public class UserDbHelper extends SQLiteOpenHelper {

    //定义数据库表名
    public static final String DB_NAME = "tb_user";
    /** 创建用户信息表 **/
    private static final String CREATE_USER_DB = "create table tb_user (" +
            "id integer primary key autoincrement," +
            "uuid text," +
            "username text," +
            "password text )";


    public UserDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 注册时添加用户信息
     * @param user 学生用户
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uuid",user.getUuid());
        values.put("username",user.getUsername());
        values.put("password",user.getPassword());
        db.insert(DB_NAME,null,values);
        values.clear();
    }

    /**
     * 登陆时查询用户信息
     * @return users 查询到的用户
     */
    public LinkedList<User> readUsers() {
        LinkedList<User> users = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from tb_user",null);
        if(cursor.moveToFirst()) {
            do{
                String uuid = cursor.getString(cursor.getColumnIndex("uuid"));
                String username = cursor.getString(cursor.getColumnIndex("username"));
                String password = cursor.getString(cursor.getColumnIndex("password"));
                User user = new User();
                user.setUuid(uuid);
                user.setUsername(username);
                user.setPassword(password);
                users.add(user);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return users;
    }

    /**
     * 修改密码功能
     * @param username 用户名
     * @param password 密码
     * @return 是否修改好
     */
    public boolean updateUser(String username,String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "update tb_user set password=? where username=?";
        String[] obj = new String[]{password,username};
        db.execSQL(sql,obj);
        return true;
    }

}
