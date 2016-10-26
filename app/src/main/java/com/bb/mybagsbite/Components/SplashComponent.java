package com.bb.mybagsbite.Components;

import com.bb.mybagsbite.Activity.SplashActivity;
import com.bb.mybagsbite.Modules.SplashModule;
import com.bb.mybagsbite.Scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by eaarcenal on 10/26/16.
 */

@ActivityScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
