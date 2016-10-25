package com.bb.mybagsbite.Activity;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.bb.mybagsbite.Fragments.RegisterFragment;
import com.bb.mybagsbite.Modules.RegisterModule;
import com.bb.mybagsbite.MyBagsBiteApp;
import com.bb.mybagsbite.Presenters.RegisterPresenter;
import com.bb.mybagsbite.R;
import com.bb.mybagsbite.Services.RegisterService;
import com.bb.mybagsbite.Views.RegisterView;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by eaarcenal on 10/25/16.
 */

public class RegisterActivity extends BaseActivity implements RegisterView {

    @Inject
    RegisterPresenter mPresenter;

    @BindView(R.id.reg_layout)
    View mRegView;

    @BindView(R.id.reg_address_field)
    EditText address;

    @BindView(R.id.reg_first_name_field)
    EditText firstName;

    @BindView(R.id.reg_last_name_field)
    EditText lastName;

    @BindView(R.id.reg_username_field)
    EditText username;

    @BindView(R.id.reg_password_field)
    EditText password;

    @BindView(R.id.reg_password_confirm_field)
    EditText confirmPassword;

    private ResponseReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);
        ButterKnife.bind(this);

        MyBagsBiteApp.get(this).getAppComponent()
                .plus(new RegisterModule(this, this))
                .inject(this);

        mPresenter.initialize();

        IntentFilter filter = new IntentFilter(ResponseReceiver.ACTION_RESP);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        receiver = new ResponseReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @OnClick(R.id.reg_register_btn)
    @Override
    public void onRegisterClicked() {
        Log.d("BUTTON","on Register");

        Intent i = new Intent(this,RegisterFragment.class);
        i.putExtra(RegisterFragment.FIRST_NAME,firstName.getText().toString());
        i.putExtra(RegisterFragment.LAST_NAME,lastName.getText().toString());
        i.putExtra(RegisterFragment.ADDRESS,address.getText().toString());
        i.putExtra(RegisterFragment.USERNAME,username.getText().toString());
        i.putExtra(RegisterFragment.PASSWORD,password.getText().toString());

        startService(i);
    }

    @OnClick(R.id.reg_cancel_btn)
    @Override
    public void onCancelClicked() {

    }

    public class ResponseReceiver extends BroadcastReceiver {
        public static final String ACTION_RESP =
                "REGISTER_STATUS";

        @Override
        public void onReceive(Context context, Intent intent) {
            String success = intent.getStringExtra(RegisterFragment.STATUS);
            if(success.equals("OK")){
                Log.d("DB","OK");
                Toast.makeText(MyBagsBiteApp.get(context),"Register successful",Toast.LENGTH_SHORT).show();
            }
            else{
                Log.d("DB","NOT OK");
                Toast.makeText(MyBagsBiteApp.get(context),"Register unsuccessful",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
