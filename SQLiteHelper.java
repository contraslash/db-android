package com.contraslash.android.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by ma0 on 11/3/15.
 */
public class SQLiteHelper extends SQLiteOpenHelper{


    private String TAG = "SQLiteHelper";
    private static final String DATABASE_NAME = "";
    private static final int DATABASE_VERSION = 1;


    Table [] tables = {
    };

    // Database creation sql statement
    private static final String DATABASE_CREATE = "";

    public SQLiteHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        for(Table table: tables)
        {
            String sentence = Utils.createTable(table);
            Log.i(TAG,sentence);
            database.execSQL(sentence);
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion)
    {

//        for(Table table: tables)
//        {
//            String sentence = Utils.deleteTable(table);
//            Log.i(TAG, sentence);
//            database.execSQL(sentence);
//        }
        onCreate(database);
        patches(database, oldVersion);
    }

    Table [] tables1 = {
    };


    private void patches(SQLiteDatabase database, int oldVersion)
    {

    }

    public void purgeDatabase()
    {
        SQLiteDatabase db = getWritableDatabase();
        for(Table table: tables1)
        {
            String drop  = Utils.deleteTable(table);
            Log.i(TAG,drop);
            db.execSQL(drop);
            String sentence = Utils.createTable(table);
            Log.i(TAG,sentence);
            db.execSQL(sentence);
        }
    }
}
