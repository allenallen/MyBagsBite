package com.bb.mybagsbite.Services;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.os.ResultReceiver;
import android.util.Log;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class RegisterService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    public static final String CLASS_NAME = "RegisterService";
    public static final String REGISTER = "com.bb.mybagsbite.Services.action.REGISTER";
    //private static final String ACTION_BAZ = "com.bb.mybagsbite.Services.action.BAZ";

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String USERNAME = "userName";
    private static final String PASSWORD = "password";
    private static final String ADDRESS = "address";

    public RegisterService() {
        super("RegisterService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void registerAction(Context context, ResultReceiver rec,String firstName, String lastName, String username,
                                      String password, String address) {
        Intent intent = new Intent(context, RegisterService.class);
        intent.setAction(REGISTER);
        intent.putExtra(FIRST_NAME, firstName);
        intent.putExtra(LAST_NAME, lastName);
        intent.putExtra(USERNAME, username);
        intent.putExtra(PASSWORD, password);
        intent.putExtra(ADDRESS, address);
        intent.putExtra("receiverTag",rec);
        context.startService(intent);

    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (REGISTER.equals(action)) {
                final String firstName = intent.getStringExtra(FIRST_NAME);
                final String lastName = intent.getStringExtra(LAST_NAME);
                final String username = intent.getStringExtra(USERNAME);
                final String password = intent.getStringExtra(PASSWORD);
                final String address = intent.getStringExtra(ADDRESS);
                handleActionFoo(firstName, lastName, username, password, address);

                ResultReceiver rec = intent.getParcelableExtra("receiverTag");
                Bundle b= new Bundle();
                b.putString("ServiceTag","register complete");
                rec.send(0, b);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String ... args) {

        //Toast.makeText(this,"Register Successful",Toast.LENGTH_SHORT);
        Log.d("ON REGISTER SERVICE:", "handleactionfoo");
        for(String s : args){
            Log.d("ON REGISTER:", s);
        }

    }


}