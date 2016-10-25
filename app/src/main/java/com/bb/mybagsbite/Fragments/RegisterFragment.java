package com.bb.mybagsbite.Fragments;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bb.mybagsbite.Activity.RegisterActivity;
import com.bb.mybagsbite.Helpers.DBHelper;

/**
 * Created by eaarcenal on 10/25/16.
 */

public class RegisterFragment extends IntentService {

    public static final String CLASS = "RegisterFragment";
    public static final String STATUS = "status";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String ADDRESS = "address";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";



    public RegisterFragment() {
        super(CLASS);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        String firstName = intent.getStringExtra(FIRST_NAME);
        String lastName = intent.getStringExtra(LAST_NAME);
        String address = intent.getStringExtra(ADDRESS);
        String username = intent.getStringExtra(USERNAME);
        String password = intent.getStringExtra(PASSWORD);

        DBHelper db = new DBHelper(this);
        boolean succ = db.insertUser(firstName,lastName,username,password,address);

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(RegisterActivity.ResponseReceiver.ACTION_RESP);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);

        if(succ){
            Log.d("STATUS","OK");
            broadcastIntent.putExtra(STATUS, "OK");
        }
        else {
            Log.d("STATUS","OK");
            broadcastIntent.putExtra(STATUS, "NOT OK");
        }

        sendBroadcast(broadcastIntent);
    }
}
