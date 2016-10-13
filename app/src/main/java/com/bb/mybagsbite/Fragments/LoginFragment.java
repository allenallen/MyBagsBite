package com.bb.mybagsbite.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.mybagsbite.Activity.HomePage;
import com.bb.mybagsbite.R;
import com.bb.mybagsbite.Receiver.AppResultReceiver;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener,AppResultReceiver.Receiver{
    EditText username;
    EditText password;
    AppResultReceiver receiver;

    private FirebaseAuth.AuthStateListener mAuthListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login, container, false);
        initializeFieldsAndButtons(view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initializeFieldsAndButtons(View view) {
        username = (EditText) view.findViewById(R.id.username_field);
        password = (EditText) view.findViewById(R.id.password_field);
        Button login = (Button) view.findViewById(R.id.login_btn);
        Button register = (Button) view.findViewById(R.id.register_btn);
        receiver = new AppResultReceiver(new Handler());
        receiver.setReceiver(this);

        btnSetOnClick(login,register);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
//                    Intent i = new HomePage();
//                    startActivity(i);
                    Intent i = new Intent(getContext(),HomePage.class);
                    startActivity(i);
                } else {
                    // User is signed out
                    //Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    private void btnSetOnClick(Button ... btns) {
        for(Button b : btns){
            b.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        int button = v.getId();

        switch(button){
            case R.id.login_btn:
                break;
            case R.id.register_btn:
                Log.d("onRegBtn","Clicked");
                callRegisterFragment();
                break;
        }
    }

    private void callRegisterFragment() {
        Fragment regFrag = RegisterFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        //ft.setCustomAnimations(R.anim.slide_left,R.anim.slide_right);
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out,
                android.R.anim.fade_in,android.R.anim.fade_out);
        ft.replace(R.id.frag_container,regFrag).addToBackStack(null).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d("ONRECEIVERESULT","OK");

    }
}
