package com.bb.mybagsbite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.bb.mybagsbite.Fragments.LoginFragment;
import com.bb.mybagsbite.Fragments.RegisterFragment;
import com.bb.mybagsbite.Receiver.AppResultReceiver;
import com.bb.mybagsbite.Services.RegisterService;

public class LoginActivity extends FragmentActivity
{
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_container);

        LoginFragment lf = new LoginFragment();
        //getFragmentManager().beginTransaction().add(R.id.frag_container,lf).commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frag_container,lf).commit();

    }

}
