package com.bb.mybagsbite.Components;

import com.bb.mybagsbite.Activity.HomeActivity;
import com.bb.mybagsbite.Modules.HomeModule;
import com.bb.mybagsbite.Scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by eaarcenal on 11/9/16.
 */
@ActivityScope
@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {
    void inject(HomeActivity homeActivity);
}
