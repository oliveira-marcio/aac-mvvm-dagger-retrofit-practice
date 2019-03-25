package com.androidtutz.anushka.memberapp;

import android.app.Application;

import com.androidtutz.anushka.memberapp.Modules.DateAndTimeModule;
import com.androidtutz.anushka.memberapp.Modules.MemberDataModule;
import com.androidtutz.anushka.memberapp.Modules.MessagesModule;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 1/25/2018.
 */

public class App extends Application{


    private static App app;
    private MemberAppComponent memberAppComponent;


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
                .messagesModule(new MessagesModule())
                .build();


    }


    public MemberAppComponent getMemberAppComponent(){


        return this.memberAppComponent;
    }

}
