package com.barrera.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "formRegister"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        updateMyDatabase(this.getWritableDatabase(), DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, newVersion);
    }

    private void updateMyDatabase(SQLiteDatabase db, int newVersion) {
        if (DB_VERSION != 1) {
            db.execSQL("CREATE TABLE USER (_id INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT,  NAME TEXT, USERNAME TEXT, PASSWORD TEXT, GENRE TEXT) ");
        }
    }

    public boolean insertUser(String name, String username, String email, String password, String genre) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues userValues = new ContentValues();
        userValues.put("NAME", name);
        userValues.put("USERNAME", username);
        userValues.put("PASSWORD", password);
        userValues.put("EMAIL", email);
        userValues.put("GENRE", genre);
        return db.insert("USER", null, userValues) != -1;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM USER", null);
        return result;
    }

    public Cursor getLogin(String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM USER WHERE EMAIL = '" + email + "' AND PASSWORD = '" + pass + "'", null);
        return result;
    }
}