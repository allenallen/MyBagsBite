package com.bb.mybagsbite.Modules;

import android.support.v7.app.AppCompatActivity;

import com.bb.mybagsbite.Presenters.LoginPresenter;
import com.bb.mybagsbite.Presenters.LoginPresenterImpl;
import com.bb.mybagsbite.Scopes.ActivityScope;
import com.bb.mybagsbite.Views.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eaarcenal on 10/25/16.
 */

@Module
public class LoginModule {

    private AppCompatActivity mActivity;

    private LoginView mView;

    public LoginModule(AppCompatActivity activity, LoginView view){
        this.mActivity = activity;
        this.mView = view;
    }

    @ActivityScope
    @Provides
    public AppCompatActivity provideActivity() {
        return mActivity;
    }

    @ActivityScope
    @Provides
    public LoginView provideView() {
        return mView;
    }

    @ActivityScope
    @Provides
    public LoginPresenter providePresenter(LoginPresenterImpl presenter) {
        return presenter;
    }

}
