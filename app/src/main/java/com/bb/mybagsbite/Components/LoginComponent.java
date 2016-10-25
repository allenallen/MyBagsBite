package com.bb.mybagsbite.Components;

import com.bb.mybagsbite.Activity.LoginActivity;
import com.bb.mybagsbite.Modules.LoginModule;
import com.bb.mybagsbite.Scopes.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by eaarcenal on 10/25/16.
 */

@ActivityScope
@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
