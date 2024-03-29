package com.example.tanauan_tales;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    private static final String dbName = "myDatabase";
    private static final int dbVersion = 3;
    private static final String dbTable = "myTable";
    //0
    private static final String dbCol_ID = "ID";
    //1
    private static final String dbCol_Name = "NAME";
    //2
    private static final String dbCol_Email = "EMAIL";
    //3
    private static final String dbCol_Password = "PASSWORD";

    private static final String createDB = "CREATE TABLE " + dbTable +
            "(" + dbCol_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            dbCol_Name + " TEXT, " +
            dbCol_Email + " TEXT, " +
            dbCol_Password + " TEXT)";

    private Context context;

    public DatabaseManager(Context context) {
        super(context, dbName, null, dbVersion);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + dbTable);
        onCreate(sqLiteDatabase);
    }

    public void setData(String name, String email, String pass)
    {
        SQLiteDatabase dbInstance = this.getWritableDatabase();
        ContentValues contents = new ContentValues();

        contents.put(dbCol_Name, name);
        contents.put(dbCol_Email, email);
        contents.put(dbCol_Password, pass);

        dbInstance.insert(dbTable, null, contents);
        dbInstance.close();
    }

    public String[][] getData()
    {
        SQLiteDatabase dbInstance = this.getReadableDatabase();
        ArrayList<String[]> myList = new ArrayList<>();
        Cursor dbContents = dbInstance.rawQuery("SELECT * FROM " + dbTable, null);
        if (dbContents.moveToFirst())
        {
            do {
                myList.add(new String[]{dbContents.getString(2), dbContents.getString(3)});
            } while (dbContents.moveToNext());
        }
        dbInstance.close();
        return myList.toArray(new String[0][0]);
    }

    public boolean checkLoginCredentials(String email, String password) {
        SQLiteDatabase dbInstance = this.getReadableDatabase();
        Cursor cursor = dbInstance.rawQuery("SELECT * FROM " + dbTable +
                        " WHERE " + dbCol_Email + "=? AND " + dbCol_Password + "=?",
                new String[]{email, password});

        boolean isValid = cursor.moveToFirst();
        cursor.close();
        dbInstance.close();
        return isValid;
    }

    public String getUserNameByEmail(String email) {
        SQLiteDatabase dbInstance = this.getReadableDatabase();
        Cursor cursor = dbInstance.rawQuery("SELECT " + dbCol_Name + " FROM " + dbTable +
                        " WHERE " + dbCol_Email + "=?",
                new String[]{email});

        String userName = "";
        if (cursor.moveToFirst()) {
            userName = cursor.getString(0);
        }

        cursor.close();
        dbInstance.close();
        return userName;
    }

    public void logoutUser() {
        SharedPreferences preferences = context.getSharedPreferences("name", Context.MODE_PRIVATE);
        preferences.edit().clear().apply();
    }

}
