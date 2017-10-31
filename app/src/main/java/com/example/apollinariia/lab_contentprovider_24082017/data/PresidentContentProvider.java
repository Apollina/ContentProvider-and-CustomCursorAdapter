package com.example.apollinariia.lab_contentprovider_24082017.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.apollinariia.lab_contentprovider_24082017.data.DatabaseHelper;

import static com.example.apollinariia.lab_contentprovider_24082017.data.PresidentContract.AUTHORITY;
import static com.example.apollinariia.lab_contentprovider_24082017.data.PresidentContract.PATH_PRESIDENTS;
import static com.example.apollinariia.lab_contentprovider_24082017.data.PresidentContract.PresidentEntry.TABLE_NAME;

/**
 * Created by Apollinariia on 8/30/2017.
 */

public class PresidentContentProvider extends ContentProvider{

        private DatabaseHelper db;

        public static final int PRESIDENTS = 100;
        public static final int PRESIDENTS_ID = 101;

        private static final UriMatcher sUriMatcher = buildUriMatcher();


        public static UriMatcher buildUriMatcher() {
            UriMatcher URIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

            URIMatcher.addURI(AUTHORITY, PATH_PRESIDENTS, PRESIDENTS);
            URIMatcher.addURI(AUTHORITY, PATH_PRESIDENTS + "/#", PRESIDENTS_ID);

            return URIMatcher;
        }



        @Override
        public boolean onCreate() {
            db = new DatabaseHelper(getContext());
            return true;
        }

        @Override
        public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                            String[] selectionArgs, String sortOrder) {

            final SQLiteDatabase dataBase = db.getReadableDatabase();


            int match = sUriMatcher.match(uri);
            Cursor retCursor;

            switch (match) {
                case PRESIDENTS:
                    retCursor = dataBase.query(TABLE_NAME,
                            projection,
                            selection,
                            selectionArgs,
                            null,
                            null,
                            sortOrder);
                    break;
                case PRESIDENTS_ID:
                    String id = uri.getPathSegments().get(1);

                    String mSelection = "_id=?";
                    String[] mSelectionArgs = new String[]{id};

                    retCursor =  dataBase.query(TABLE_NAME,
                            projection,
                            mSelection,
                            mSelectionArgs,
                            null,
                            null,
                            sortOrder);
                    break;


                default:
                    throw new UnsupportedOperationException("Unknown uri: " + uri);
            }
            retCursor.setNotificationUri(getContext().getContentResolver(), uri);
            return retCursor;
        }


        @Nullable
        @Override
        public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {

            throw new UnsupportedOperationException("Not yet implemented");
        }


        @Override
        public int update(@NonNull Uri uri, ContentValues values, String selection,
                          String[] selectionArgs) {

            throw new UnsupportedOperationException("Not yet implemented");
        }


        @Override
        public String getType(@NonNull Uri uri) {

            throw new UnsupportedOperationException("Not yet implemented");
        }

}

