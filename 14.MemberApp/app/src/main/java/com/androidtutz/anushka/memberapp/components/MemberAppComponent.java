package com.androidtutz.anushka.memberapp.components;

import com.androidtutz.anushka.memberapp.MainActivity;
import com.androidtutz.anushka.memberapp.modules.DateAndTimeModule;
import com.androidtutz.anushka.memberapp.modules.MemberDataModule;

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
