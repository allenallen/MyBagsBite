package com.bb.mybagsbite.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import com.bb.mybagsbite.Modules.HomeModule;
import com.bb.mybagsbite.MyBagsBiteApp;
import com.bb.mybagsbite.Presenters.HomePresenter;
import com.bb.mybagsbite.R;
import com.bb.mybagsbite.Views.HomeView;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eaarcenal on 11/9/16.
 */

public class HomeActivity extends BaseActivity implements HomeView{
    @Inject
    HomePresenter mPresenter;

    //TODO: home layout
//    @BindView(R.id.home_view)
//    View mHomeView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: home layout
        //setContentView(R.layout.home_layout);

        ButterKnife.bind(this);

        MyBagsBiteApp.get(this).getAppComponent()
                .plus(new HomeModule(this, this))
                .inject(this);

        mPresenter.initialize();
    }

    @Override
    public void userOptions(Button... buttons) {

    }
}
