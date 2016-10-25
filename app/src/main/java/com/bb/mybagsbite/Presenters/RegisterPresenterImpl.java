package com.bb.mybagsbite.Presenters;

import android.support.v7.app.AppCompatActivity;

import com.bb.mybagsbite.Views.RegisterView;

import javax.inject.Inject;

/**
 * Created by eaarcenal on 10/25/16.
 */

public class RegisterPresenterImpl implements RegisterPresenter {

    private AppCompatActivity mActivity;

    private RegisterView mView;

    @Inject
    public RegisterPresenterImpl(AppCompatActivity activity, RegisterView view) {
        mActivity = activity;
        mView = view;
    }

    @Override
    public void initialize() {

    }
}
