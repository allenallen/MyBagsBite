package com.bb.mybagsbite.Modules;

import android.support.v7.app.AppCompatActivity;

import com.bb.mybagsbite.Presenters.HomePresenter;
import com.bb.mybagsbite.Presenters.HomePresenterImpl;
import com.bb.mybagsbite.Scopes.ActivityScope;
import com.bb.mybagsbite.Views.HomeView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eaarcenal on 11/9/16.
 */

@Module
public class HomeModule {

    private AppCompatActivity mActivity;
    private HomeView mView;

    public HomeModule(AppCompatActivity mActivity, HomeView mView) {
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
    public HomeView provideView() {
        return mView;
    }

    @ActivityScope
    @Provides
    public HomePresenter providePresenter(HomePresenterImpl homePresenter) {
        return homePresenter;
    }
}
