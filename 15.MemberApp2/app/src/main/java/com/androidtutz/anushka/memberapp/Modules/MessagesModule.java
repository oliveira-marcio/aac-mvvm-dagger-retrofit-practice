package com.androidtutz.anushka.memberapp.modules;

import com.androidtutz.anushka.memberapp.models.MessageGenerator;
import com.androidtutz.anushka.memberapp.scopes.WelcomeActivityScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 2/4/2018.
 */
@Module
public class MessagesModule {

   @WelcomeActivityScope
   @Provides
public MessageGenerator provideMessageGenerator(){

   return new MessageGenerator();
}



}
