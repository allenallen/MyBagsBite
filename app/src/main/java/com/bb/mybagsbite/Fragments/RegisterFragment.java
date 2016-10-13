package com.bb.mybagsbite.Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bb.mybagsbite.R;
import com.bb.mybagsbite.Receiver.AppResultReceiver;
import com.bb.mybagsbite.Services.RegisterService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener,AppResultReceiver.Receiver{

    EditText firstName;
    EditText lastName;
    EditText address;
    EditText username;
    EditText password;
    EditText confPassword;
    AppResultReceiver rec;


    public static RegisterFragment newInstance() {
        RegisterFragment fragment = new RegisterFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rec = new AppResultReceiver(new Handler());
        rec.setReceiver(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        initializeFieldsAndButtons(view);

        return view;
    }

    private void initializeFieldsAndButtons(View view) {
        firstName = (EditText) view.findViewById(R.id.reg_first_name_field);
        lastName = (EditText) view.findViewById(R.id.reg_last_name_field);
        address = (EditText) view.findViewById(R.id.reg_address_field);
        username = (EditText) view.findViewById(R.id.reg_username_field);
        password = (EditText) view.findViewById(R.id.reg_password_field);
        confPassword = (EditText) view.findViewById(R.id.reg_password_confirm_field);
        Button register = (Button) view.findViewById(R.id.reg_register_btn);
        Button cancel = (Button) view.findViewById(R.id.reg_cancel_btn);

        btnSetOnClick(cancel,register);
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
            case R.id.reg_cancel_btn:
                getFragmentManager().popBackStack();
                break;
            case R.id.reg_register_btn:
                Log.d("onRegBtn","Clicked");
                RegisterService.registerAction(getActivity(),rec,firstName.getText().toString(),lastName.getText().toString()
                ,username.getText().toString(),password.getText().toString(),address.getText().toString());
                getFragmentManager().popBackStack();
                //callRegisterFragment();
                break;
        }
    }


    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        switch(resultCode){
            case 0:
                //Toast.makeText(getContext(),resultData.getString("ServiceTag"),Toast.LENGTH_SHORT).show();
        }
    }
}
