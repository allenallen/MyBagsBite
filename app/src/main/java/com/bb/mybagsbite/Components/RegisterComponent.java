package com.bb.mybagsbite.Components;

import com.bb.mybagsbite.Activity.RegisterActivity;
import com.bb.mybagsbite.Modules.RegisterModule;
import com.bb.mybagsbite.Scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by eaarcenal on 10/25/16.
 */

@ActivityScope
@Subcomponent(modules = {RegisterModule.class})
public interface RegisterComponent {
    void inject(RegisterActivity activity);
}
