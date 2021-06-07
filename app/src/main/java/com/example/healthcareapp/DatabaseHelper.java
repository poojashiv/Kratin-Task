package com.example.healthcareapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "HealthCare.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_table";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_MOBILE = "mobile";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_ADDRESS = "address";

    SQLiteDatabase database;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_MOBILE + " TEXT, " +
                COLUMN_AGE + " TEXT, " +
                COLUMN_PASSWORD + " TEXT, " +
                COLUMN_ADDRESS + " TEXT);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void open() throws SQLException {
        database = this.getWritableDatabase();
    }


    public void close() {
        this.close();
    }

    public void addData(String name, String mobile, String age, String password, String address) {

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_MOBILE, mobile);
        contentValues.put(COLUMN_AGE, age);
        contentValues.put(COLUMN_PASSWORD, password);
        contentValues.put(COLUMN_ADDRESS, address);

        long result = database.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            Toast.makeText(context, "failed", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "SigUp Successfully", Toast.LENGTH_LONG).show();
        }
    }

    public boolean checkUserLogin(String mobile, String password) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor mCursor = database.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE mobile=? AND password=?", new String[]{mobile, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
//            Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}