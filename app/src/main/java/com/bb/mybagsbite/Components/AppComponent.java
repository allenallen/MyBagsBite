package com.bb.mybagsbite.Components;

import android.app.Application;

import com.bb.mybagsbite.Modules.AppModule;
import com.bb.mybagsbite.Modules.LoginModule;
import com.bb.mybagsbite.Modules.RegisterModule;
import com.bb.mybagsbite.Modules.SplashModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by eaarcenal on 10/25/16.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Application application();

    LoginComponent plus(LoginModule loginModule);
    RegisterComponent plus(RegisterModule registerModule);
    SplashComponent plus(SplashModule splashModule);
}
