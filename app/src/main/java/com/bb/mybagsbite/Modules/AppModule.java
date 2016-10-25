package com.bb.mybagsbite.Modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by eaarcenal on 10/25/16.
 */

@Module
public class AppModule {

    private Application mApp;

    public AppModule(Application app){
        this.mApp = app;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApp;
    }

}
