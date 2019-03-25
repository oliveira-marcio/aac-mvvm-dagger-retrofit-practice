package com.androidtutz.anushka.memberapp;

import android.app.Application;


import com.androidtutz.anushka.memberapp.components.DaggerMemberAppComponent;
import com.androidtutz.anushka.memberapp.components.DaggerWelcomeActivityComponent;
import com.androidtutz.anushka.memberapp.components.MemberAppComponent;
import com.androidtutz.anushka.memberapp.components.WelcomeActivityComponent;
import com.androidtutz.anushka.memberapp.modules.DateAndTimeModule;
import com.androidtutz.anushka.memberapp.modules.MemberDataModule;
import com.androidtutz.anushka.memberapp.modules.MessagesModule;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 1/25/2018.
 */

public class App extends Application{


    private static App app;
    private MemberAppComponent memberAppComponent;
    private WelcomeActivityComponent welcomeActivityComponent;



    public static App getApp(){


        return app;
    }




    @Override
    public void onCreate() {
        super.onCreate();

        app=this;
        memberAppComponent = DaggerMemberAppComponent.builder()
                .memberDataModule(new MemberDataModule(getApplicationContext()))
                .dateAndTimeModule(new DateAndTimeModule())
                .build();

        welcomeActivityComponent = DaggerWelcomeActivityComponent.builder()
                .memberAppComponent(memberAppComponent)
                .messagesModule(new MessagesModule())
                .build();



    }


    public MemberAppComponent getMemberAppComponent(){


        return this.memberAppComponent;
    }
    public WelcomeActivityComponent getWelcomeActivityComponent() {
        return welcomeActivityComponent;
    }

}
