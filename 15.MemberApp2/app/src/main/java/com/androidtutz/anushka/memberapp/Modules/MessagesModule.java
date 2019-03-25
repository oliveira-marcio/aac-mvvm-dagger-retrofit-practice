package com.androidtutz.anushka.memberapp.Modules;

import com.androidtutz.anushka.memberapp.Models.MessageGenerator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 2/4/2018.
 */
@Module
public class MessagesModule {

   @Provides @Singleton
public MessageGenerator provideMessageGenerator(){

   return new MessageGenerator();
}



}
