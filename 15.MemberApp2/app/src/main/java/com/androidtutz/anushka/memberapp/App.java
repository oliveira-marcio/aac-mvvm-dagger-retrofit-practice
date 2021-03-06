package com.androidtutz.anushka.memberapp;

import android.app.Application;

import com.androidtutz.anushka.memberapp.components.DaggerMemberAppComponent;
import com.androidtutz.anushka.memberapp.components.MemberAppComponent;
import com.androidtutz.anushka.memberapp.modules.DateAndTimeModule;
import com.androidtutz.anushka.memberapp.modules.MemberDataModule;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 1/25/2018.
 */

public class App extends Application {


    private static App app;
    private MemberAppComponent memberAppComponent;


    public static App getApp() {


        return app;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        memberAppComponent = DaggerMemberAppComponent.builder()
                .memberDataModule(new MemberDataModule(getApplicationContext()))
                .dateAndTimeModule(new DateAndTimeModule())
                .build();


    }


    public MemberAppComponent getMemberAppComponent() {


        return this.memberAppComponent;
    }

}
