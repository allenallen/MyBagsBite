package com.bb.mybagsbite.Presenters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bb.mybagsbite.Activity.LoginActivity;
import com.bb.mybagsbite.Views.LoginView;

import javax.inject.Inject;

/**
 * Created by eaarcenal on 10/25/16.
 */

public class LoginPresenterImpl implements LoginPresenter{

    private AppCompatActivity mActivity;

    private LoginView mView;

    @Inject
    public LoginPresenterImpl(AppCompatActivity activity, LoginView view) {
        mActivity = activity;
        mView = view;
    }

    @Override
    public void initialize() {
    }
}
