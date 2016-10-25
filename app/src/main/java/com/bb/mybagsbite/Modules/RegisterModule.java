package com.bb.mybagsbite.Modules;

import android.support.v7.app.AppCompatActivity;

import com.bb.mybagsbite.Presenters.RegisterPresenter;
import com.bb.mybagsbite.Presenters.RegisterPresenterImpl;
import com.bb.mybagsbite.Scopes.ActivityScope;
import com.bb.mybagsbite.Views.RegisterView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eaarcenal on 10/25/16.
 */

@Module
public class RegisterModule {

    private AppCompatActivity mActivity;

    private RegisterView mView;

    public RegisterModule(AppCompatActivity activity, RegisterView view){
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
    public RegisterView provideView() {
        return mView;
    }

    @ActivityScope
    @Provides
    public RegisterPresenter providePresenter(RegisterPresenterImpl presenter) {
        return presenter;
    }

}
