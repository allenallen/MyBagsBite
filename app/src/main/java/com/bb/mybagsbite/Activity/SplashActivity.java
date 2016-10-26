package com.bb.mybagsbite.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bb.mybagsbite.Modules.SplashModule;
import com.bb.mybagsbite.MyBagsBiteApp;
import com.bb.mybagsbite.Presenters.SplashPresenter;
import com.bb.mybagsbite.R;
import com.bb.mybagsbite.Views.SplashView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eaarcenal on 10/26/16.
 */

public class SplashActivity extends BaseActivity implements SplashView {
    @Inject
    SplashPresenter mPresenter;

    @BindView(R.id.splashView)
    View mSplashView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        MyBagsBiteApp.get(this).getAppComponent()
                .plus(new SplashModule(this, this))
                .inject(this);

        mPresenter.initialize();
    }

    @Override
    public View getSplashView() {
        return mSplashView;
    }
}
