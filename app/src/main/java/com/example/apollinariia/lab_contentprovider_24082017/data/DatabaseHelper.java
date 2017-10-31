package com.example.apollinariia.lab_contentprovider_24082017.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.apollinariia.lab_contentprovider_24082017.data.PresidentContract;

/**
 * Created by Apollinariia on 8/28/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "President.db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE = "CREATE TABLE " + PresidentContract.PresidentEntry.TABLE_NAME + " ( " +
                PresidentContract.PresidentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PresidentContract.PresidentEntry.COL_1 + " TEXT NOT NULL, " +
                PresidentContract.PresidentEntry.COL_2 + " TEXT NOT NULL, " +
                PresidentContract.PresidentEntry.COL_3 + " INTEGER NOT NULL, " +
                PresidentContract.PresidentEntry.COL_4 + " INTEGER NOT NULL" + ");";

        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PresidentContract.PresidentEntry.TABLE_NAME);
        onCreate(db);

    }

}
