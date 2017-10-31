package com.example.apollinariia.lab_contentprovider_24082017.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import com.example.apollinariia.lab_contentprovider_24082017.data.PresidentContract.PresidentEntry;

/**
 * Created by Apollinariia on 8/30/2017.
 */

public class InsertPresidents {

    public static void insertPresidentData (SQLiteDatabase db) {
        if (db == null) {
            return;
        }
        //create a list of fake guests
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(PresidentEntry.COL_1, "Stahlberg");
        cv.put(PresidentEntry.COL_2, "Kaarlo Juho");
        cv.put(PresidentEntry.COL_3, 1919);
        cv.put(PresidentEntry.COL_4, 1925);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentEntry.COL_1, "Relander");
        cv.put(PresidentEntry.COL_2, "Lauri Kristian");
        cv.put(PresidentEntry.COL_3, 1925);
        cv.put(PresidentEntry.COL_4, 1931);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Svinhufvud");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Pehr Evind");
        cv.put(PresidentContract.PresidentEntry.COL_3, 1931);
        cv.put(PresidentContract.PresidentEntry.COL_4, 1937);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Kallio");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Kyösti");
        cv.put(PresidentContract.PresidentEntry.COL_3, 1937);
        cv.put(PresidentContract.PresidentEntry.COL_4, 1940);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Ryti");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Risto");
        cv.put(PresidentContract.PresidentEntry.COL_3, 1940);
        cv.put(PresidentContract.PresidentEntry.COL_4, 1944);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Mannerheim");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Carl Gustaf Emil");
        cv.put(PresidentContract.PresidentEntry.COL_3, 1944);
        cv.put(PresidentContract.PresidentEntry.COL_4, 1946);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Paasikivi");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Juho Kusti");
        cv.put(PresidentContract.PresidentEntry.COL_3, 1946);
        cv.put(PresidentContract.PresidentEntry.COL_4, 1956);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Kekkonen");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Urho");
        cv.put(PresidentContract.PresidentEntry.COL_3, 1956);
        cv.put(PresidentContract.PresidentEntry.COL_4, 1982);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Koivisto");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Mauno");
        cv.put(PresidentContract.PresidentEntry.COL_3, 1982);
        cv.put(PresidentContract.PresidentEntry.COL_4, 1994);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Ahtisaari");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Martti");
        cv.put(PresidentContract.PresidentEntry.COL_3, 1994);
        cv.put(PresidentContract.PresidentEntry.COL_4, 2000);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Halonen");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Tarja");
        cv.put(PresidentContract.PresidentEntry.COL_3, 2000);
        cv.put(PresidentContract.PresidentEntry.COL_4, 2012);
        list.add(cv);

        cv = new ContentValues();
        cv.put(PresidentContract.PresidentEntry.COL_1, "Niinistö");
        cv.put(PresidentContract.PresidentEntry.COL_2, "Sauli");
        cv.put(PresidentContract.PresidentEntry.COL_3, 2012);
        cv.put(PresidentContract.PresidentEntry.COL_4, 2017);
        list.add(cv);


        try {
            db.beginTransaction();
            db.delete(PresidentContract.PresidentEntry.TABLE_NAME, null, null);
            for (ContentValues c : list) {
                db.insert(PresidentContract.PresidentEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            //too bad :(
        } finally {
            db.endTransaction();
        }

    }
}
