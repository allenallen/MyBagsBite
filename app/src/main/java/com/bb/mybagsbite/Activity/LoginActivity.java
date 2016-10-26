package com.bb.mybagsbite.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bb.mybagsbite.Fragments.RegisterFragment;
import com.bb.mybagsbite.Modules.LoginModule;
import com.bb.mybagsbite.MyBagsBiteApp;
import com.bb.mybagsbite.Presenters.LoginPresenter;
import com.bb.mybagsbite.R;
import com.bb.mybagsbite.Views.LoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by eaarcenal on 10/25/16.
 */

public class LoginActivity extends BaseActivity implements LoginView {

    @Inject
    LoginPresenter mPresenter;

    @BindView(R.id.activity_login)
    View mLoginView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        MyBagsBiteApp.get(this).getAppComponent()
                .plus(new LoginModule(this, this))
                .inject(this);

        mPresenter.initialize();
    }

    @OnClick(R.id.login_btn)
    @Override
    public void onLoginButtonClicked() {
        Log.d("BUTTON","login clicked");
    }

    @OnClick(R.id.register_btn)
    @Override
    public void onRegisterButtonClicked() {

        Intent intent = new Intent(this,RegisterActivity.class);
        startActivityForResult(intent,0);
//        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == 1){
            Toast.makeText(this, "Welcome " + data.getStringExtra(RegisterFragment.FIRST_NAME), Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    //    @Override
//    public View getLoginView() {
//        return mLoginView;
//    }
}
