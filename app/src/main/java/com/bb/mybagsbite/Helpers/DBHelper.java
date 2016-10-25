package com.bb.mybagsbite.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bb.mybagsbite.Model.Users;

import static android.content.Context.MODE_PRIVATE;
import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * Created by eaarcenal on 10/14/16.
 */

public class DBHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "MyBagsBite.db"; //Name of the database
    private static final int DATABASE_VER = 1;          //Database version

    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + Users.USER_TABLE + "("
            + "id INTEGER PRIMARY KEY,"
            + Users.USER_FIRST_NAME + " VARCHAR,"
            + Users.USER_LAST_NAME + " VARCHAR,"
            + Users.USER_ADDRESS + " VARCHAR,"
            + Users.USER_EMAIL + " VARCHAR,"
            + Users.USER_USERNAME + " VARCHAR,"
            + Users.USER_PASSWORD + " VARCHAR" + ")";



    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
    
    public boolean insertUser(String ... args){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(Users.USER_FIRST_NAME,args[0]);
        cv.put(Users.USER_LAST_NAME,args[1]);
        cv.put(Users.USER_USERNAME,args[2]);
        cv.put(Users.USER_PASSWORD,args[3]);
        cv.put(Users.USER_ADDRESS,args[4]);

        try {
            db.insert(Users.USER_TABLE, null, cv);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            db.close();
        }

        return true;
    }

    public Cursor getUsers(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = null;
        try {
            res = db.rawQuery("SELECT * FROM " + Users.USER_TABLE + " WHERE " + Users.USER_USERNAME + " = '" + username + "'", null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //db.close();
        return res;
    }


}
