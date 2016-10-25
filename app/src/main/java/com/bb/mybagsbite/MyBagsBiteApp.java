package com.bb.mybagsbite;

import android.app.Application;
import android.content.Context;

import com.bb.mybagsbite.Components.AppComponent;
//import com.bb.mybagsbite.Components.DaggerAppComponent;
import com.bb.mybagsbite.Components.DaggerAppComponent;
import com.bb.mybagsbite.Modules.AppModule;


/**
 * Created by eaarcenal on 10/25/16.
 */

public class MyBagsBiteApp extends Application{

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initDaggerComponents();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public static MyBagsBiteApp get(Context context){
        return (MyBagsBiteApp) context.getApplicationContext();
    }

    private void initDaggerComponents() {

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
