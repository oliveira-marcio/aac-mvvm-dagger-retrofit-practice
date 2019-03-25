package com.androidtutz.anushka.memberapp.components;

import com.androidtutz.anushka.memberapp.WelcomeActivity;
import com.androidtutz.anushka.memberapp.models.MessageGenerator;
import com.androidtutz.anushka.memberapp.modules.MessagesModule;
import com.androidtutz.anushka.memberapp.scopes.WelcomeActivityScope;

import dagger.Component;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 2/4/2018.
 */
@WelcomeActivityScope
@Component(dependencies = MemberAppComponent.class,modules = MessagesModule.class)
public interface WelcomeActivityComponent {

    void inject(WelcomeActivity welcomeActivity);





}
