package com.androidtutz.anushka.memberapp;

import com.androidtutz.anushka.memberapp.Modules.DateAndTimeModule;
import com.androidtutz.anushka.memberapp.Modules.MemberDataModule;
import com.androidtutz.anushka.memberapp.Modules.MessagesModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 1/25/2018.
 */
@Singleton
@Component(modules ={MemberDataModule.class,DateAndTimeModule.class, MessagesModule.class})
public interface MemberAppComponent {

    void inject(MainActivity mainActivity);
    void inject(WelcomeActivity welcomeActivity);


    
}
