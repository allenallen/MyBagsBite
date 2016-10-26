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
    public static final String CONFIRM_PASSWORD = "confirmPassword";

    public static final int REGISTER_SUCCESSFUL = 1;
    public static final int REGISTER_NOT_SUCCESSFUL = 2;
    public static final int REGISTER_ERROR_PASSWORD = 3;


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
        String confirmPassword = intent.getStringExtra(CONFIRM_PASSWORD);

        boolean validPass = validatePassword(password,confirmPassword);
        boolean succ = false;

        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(RegisterActivity.ResponseReceiver.ACTION_RESP);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);

        if(validPass){
            DBHelper db = new DBHelper(this);
            succ = db.insertUser(firstName,lastName,username,password,address);
            if(succ){
                Log.d("STATUS","OK");
                broadcastIntent.putExtra(STATUS, REGISTER_SUCCESSFUL);
            }
            else {
                Log.d("STATUS","NOT OK");
                broadcastIntent.putExtra(STATUS, REGISTER_NOT_SUCCESSFUL);
            }
        }
        else{
            Log.d("STATUS","NOT OK");
            broadcastIntent.putExtra(STATUS, REGISTER_ERROR_PASSWORD);
        }



        sendBroadcast(broadcastIntent);
    }

    private boolean validatePassword(String password, String confirmPassword) {
        if(password.equals(confirmPassword)){
            return true;
        }
        else
        {
            return false;
        }
    }

}
