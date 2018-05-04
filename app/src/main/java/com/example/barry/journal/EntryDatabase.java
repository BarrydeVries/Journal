package com.example.barry.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;



public class EntryDatabase extends SQLiteOpenHelper {
    public EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static EntryDatabase instance;

    public EntryDatabase getInstance(Context context) {

        if (instance != null) {
            return instance;
        }
        else {
            instance = onCreate(db);
            return instance;
        }
    }

    @Override
    private void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + "journal" +
                "(" +
                "_id" + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                "mood" + "INTEGER," +
                "title" + "TEXT," +
                "content" + "TEXT," +
                "timestamp" + "DATETIME DEFAULT (datetime('now','localtime'))" +
                ")";
        db.execSQL(query);
        // insertion in the table
        ContentValues values = new ContentValues();
        values.put("mood" , 1);
        values.put("title" , "sad");
        values.put("content" , "booo");
        db.insert("journal", null, values);

        values.put("mood" , 2);
        values.put("title" , "happy");
        values.put("content" , "weew");
        db.insert("journal", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "journal");
        onCreate(db);
    }

    public Cursor selectAll(SQLiteDatabase db){
        getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM journal", null);
        c.moveToFirst();
        return c;
    }
}
