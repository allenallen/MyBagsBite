package com.bb.mybagsbite.Services

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.content.LocalBroadcastManager
import android.support.v4.os.ResultReceiver
import android.util.Log
import android.widget.Toast

import com.bb.mybagsbite.Fragments.RegisterFragment
import com.bb.mybagsbite.Helpers.DBHelper
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 *
 *
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class RegisterService : IntentService("RegisterService") {

    private var firebaseAuth: FirebaseAuth? = null


    override fun onHandleIntent(intent: Intent?) {
        firebaseAuth = FirebaseAuth.getInstance()

        if (intent != null) {
            val action = intent.action
            if (REGISTER == action) {
                val firstName = intent.getStringExtra(FIRST_NAME)
                val lastName = intent.getStringExtra(LAST_NAME)
                val username = intent.getStringExtra(USERNAME)
                val password = intent.getStringExtra(PASSWORD)
                val address = intent.getStringExtra(ADDRESS)
//                setIntentToHandle(intent)
//                rec = intent.getParcelableExtra<ResultReceiver>("receiverTag")
                handleActionFoo(firstName, lastName, username, password, address)

                //                ResultReceiver rec = intent.getParcelableExtra("receiverTag");
                //                Bundle b= new Bundle();
                //                b.putString("ServiceTag","register complete");
                //                rec.send(0, b);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(vararg args: String) {

        val db = DBHelper(this)
        val successReg = db.insertUser(*args)

        if (!successReg) {
            Toast.makeText(this, "Register not successful", Toast.LENGTH_SHORT).show()
        }

        //        firebaseAuth.createUserWithEmailAndPassword(args[2],args[3])
        //                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        //                    @Override
        //                    public void onComplete(@NonNull Task<AuthResult> task) {
        //                        Log.d("FIREBASE","ON CREATION");
        //                        if (!task.isSuccessful()) {
        //                            Log.d("FIREBASE",task.getException().getMessage());
        //                            Toast.makeText(getApplicationContext(), "Registration Failed",
        //                                    Toast.LENGTH_SHORT).show();
        //                        }else {
        //                            Log.d("FIREBASE","SUCCESS");
        ////                            ResultReceiver rec = getIntentToHandle().getParcelableExtra("receiverTag");
        //                            Bundle b = new Bundle();
        //                            b.putString("ServiceTag", "register complete");
        //                            rec.send(0, b);
        //                        }
        //                    }
        //                });

        //Toast.makeText(this,"Register Successful",Toast.LENGTH_SHORT);
        //        Log.d("ON REGISTER SERVICE:", "handleactionfoo");
        //        for(String s : args){
        //            Log.d("ON REGISTER:", s);
        //        }


    }


//    fun getIntentToHandle(): Intent {
//        return intentToHandle
//    }
//
//    fun setIntentToHandle(intentToHandle: Intent) {
//        this.intentToHandle = intentToHandle
//    }

    companion object {
        // TODO: Rename actions, choose action names that describe tasks that this
        // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
        val CLASS_NAME = "RegisterService"
        val REGISTER = "com.bb.mybagsbite.Services.action.REGISTER"
        //private static final String ACTION_BAZ = "com.bb.mybagsbite.Services.action.BAZ";

        private val FIRST_NAME = "firstName"
        private val LAST_NAME = "lastName"
        private val USERNAME = "userName"
        private val PASSWORD = "password"
        private val ADDRESS = "address"

//        private var intentToHandle: Intent? = null

        /**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.

         * @see IntentService
         */
        // TODO: Customize helper method
        fun registerAction(context: Context, rec: ResultReceiver, firstName: String, lastName: String, username: String,
                           password: String, address: String) {
            val intent = Intent(context, RegisterService::class.java)
            intent.action = REGISTER
            intent.putExtra(FIRST_NAME, firstName)
            intent.putExtra(LAST_NAME, lastName)
            intent.putExtra(USERNAME, username)
            intent.putExtra(PASSWORD, password)
            intent.putExtra(ADDRESS, address)
            intent.putExtra("receiverTag", rec)
            context.startService(intent)

        }
    }

}
