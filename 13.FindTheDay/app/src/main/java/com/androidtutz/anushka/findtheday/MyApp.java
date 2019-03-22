package com.androidtutz.anushka.findtheday;

import android.app.Application;

public class MyApp extends Application {

    private static MyApp myApp;
    private ApplicationComponent applicationComponent;

    public static MyApp getMyApp() {
        return myApp;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        myApp = this;
        applicationComponent = DaggerApplicationComponent.builder()
                .chooserModule(new ChooserModule())
                .build();
    }
}
