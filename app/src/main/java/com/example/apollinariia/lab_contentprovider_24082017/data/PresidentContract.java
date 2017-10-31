package com.example.apollinariia.lab_contentprovider_24082017.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.BaseColumns;


/**
 * Created by Apollinariia on 8/30/2017.
 */

public class PresidentContract {

    public static final String AUTHORITY = "com.example.apollinariia.lab_contentprovider_24082017";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);
    public static final String PATH_PRESIDENTS = "president";

    public static final class PresidentEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PRESIDENTS).build();

        public static final String TABLE_NAME = "president";
        public static final String COL_1 = "SURNAME";
        public static final String COL_2 = "NAME";
        public static final String COL_3 = "START_DATE";
        public static final String COL_4 = "END_DATE";

    }
}
