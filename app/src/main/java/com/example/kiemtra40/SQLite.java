package com.example.kiemtra40;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite extends SQLiteOpenHelper {

    public SQLite( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Insert, Update, Delete, Create
    public void QueryData(String sql){
        SQLiteDatabase db =getWritableDatabase();
        db.execSQL(sql);
    }
    //Select
    public Cursor GetData(String sql){
        SQLiteDatabase db =getWritableDatabase();
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
