package com.bb.mybagsbite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.bb.mybagsbite.Activity.HomePage;
import com.bb.mybagsbite.Fragments.LoginFragment;
import com.bb.mybagsbite.Fragments.RegisterFragment;
import com.bb.mybagsbite.Receiver.AppResultReceiver;
import com.bb.mybagsbite.Services.RegisterService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends FragmentActivity
{
    EditText username;
    EditText password;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        LoginFragment lf = new LoginFragment();
        //getFragmentManager().beginTransaction().add(R.id.frag_container,lf).commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frag_container,lf).commit();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
//                    Intent i = new HomePage();
//                    startActivity(i);
                    Intent i = new Intent(getApplicationContext(),HomePage.class);
                    startActivity(i);
                } else {
                    // User is signed out
                    //Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

    }

}
