package com.bb.mybagsbite.Presenters;

import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;

import com.bb.mybagsbite.Activity.LoginActivity;
import com.bb.mybagsbite.Helpers.AnimationUtil;
import com.bb.mybagsbite.Views.SplashView;

import javax.inject.Inject;

/**
 * Created by eaarcenal on 10/26/16.
 */

public class SplashPresenterImpl implements SplashPresenter{
    private SplashView mView;
    private AppCompatActivity mActivity;

    @Inject
    public SplashPresenterImpl(SplashView view, AppCompatActivity activity) {
        mView = view;
        mActivity = activity;
    }

    @Override
    public void initialize() {
        startSplashAnimation();
    }

    @Override
    public void startSplashAnimation() {
        View splashView = mView.getSplashView();

        splashView.setAlpha(0f);
        splashView.setVisibility(View.VISIBLE);

        ViewPropertyAnimatorCompat logoAnimator = ViewCompat.animate(splashView).alpha(1f).setDuration(4000).setListener(null);

        ViewPropertyAnimatorCompatSet animatorCompatSet = new ViewPropertyAnimatorCompatSet();
        animatorCompatSet.play(logoAnimator);
        animatorCompatSet.setListener(new ViewPropertyAnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(View view) {
                Intent intent = new Intent(mActivity, LoginActivity.class);

                if (intent != null) {
                    mActivity.startActivity(intent);
                    mActivity.finish();
                    AnimationUtil.overridePendingTransition(mActivity, AnimationUtil.ANIM_STYLE.FADE_IN);
                }
            }
        });
        animatorCompatSet.start();
    }
}
