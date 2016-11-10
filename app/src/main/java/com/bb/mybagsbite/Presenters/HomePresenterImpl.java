package com.bb.mybagsbite.Presenters;

import android.support.v7.app.AppCompatActivity;

import com.bb.mybagsbite.Views.HomeView;

import javax.inject.Inject;

/**
 * Created by eaarcenal on 11/9/16.
 */

public class HomePresenterImpl implements HomePresenter {
    private AppCompatActivity mActivity;
    private HomeView mView;

    @Inject
    public HomePresenterImpl(AppCompatActivity activity, HomeView view){
        this.mActivity = activity;
        this.mView = view;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void loadWidgets() {

    }
}
