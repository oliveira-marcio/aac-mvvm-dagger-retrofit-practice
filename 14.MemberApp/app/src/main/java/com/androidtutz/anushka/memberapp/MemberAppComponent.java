package com.androidtutz.anushka.memberapp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 1/25/2018.
 */
@Singleton
@Component(modules = {MemberDataModule.class, DateAndTimeModule.class})
public interface MemberAppComponent {

    void inject(MainActivity mainActivity);


}
