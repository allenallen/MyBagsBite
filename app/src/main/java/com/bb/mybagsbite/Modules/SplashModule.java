package com.bb.mybagsbite.Modules;

import android.support.v7.app.AppCompatActivity;

import com.bb.mybagsbite.Presenters.SplashPresenter;
import com.bb.mybagsbite.Presenters.SplashPresenterImpl;
import com.bb.mybagsbite.Scopes.ActivityScope;
import com.bb.mybagsbite.Views.SplashView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eaarcenal on 10/26/16.
 */

@Module
public class SplashModule {

    private AppCompatActivity mActivity;
    private SplashView mView;

    public SplashModule(AppCompatActivity mActivity, SplashView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    @ActivityScope
    @Provides
    public AppCompatActivity provideActivity() {
        return mActivity;
    }

    @ActivityScope
    @Provides
    public SplashView provideView() {
        return mView;
    }

    @ActivityScope
    @Provides
    public SplashPresenter providePresenter(SplashPresenterImpl splashPresenter) {
        return splashPresenter;
    }

}
