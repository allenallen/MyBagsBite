package com.bb.mybagsbite

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Handler
import android.support.v4.app.FragmentActivity
import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.widget.EditText
import android.widget.Toast

import com.bb.mybagsbite.Activity.HomePage
import com.bb.mybagsbite.Fragments.LoginFragment
import com.bb.mybagsbite.Fragments.RegisterFragment
import com.bb.mybagsbite.Receiver.AppResultReceiver
import com.bb.mybagsbite.Services.RegisterService
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : FragmentActivity() {
    internal var username: EditText? = null
    internal var password: EditText? = null
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_container)

        val lf = LoginFragment()
        //getFragmentManager().beginTransaction().add(R.id.frag_container,lf).commit();
        supportFragmentManager.beginTransaction().add(R.id.frag_container, lf).commit()

    }

    override fun onResume() {
        super.onResume()
        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
            if (user != null) {
                // User is signed in
                //                    Intent i = new HomePage();
                //                    startActivity(i);
                val i = Intent(applicationContext, HomePage::class.java)
                startActivity(i)
            } else {
                // User is signed out
                //Log.d(TAG, "onAuthStateChanged:signed_out");
            }
            // ...
        }
    }
}
