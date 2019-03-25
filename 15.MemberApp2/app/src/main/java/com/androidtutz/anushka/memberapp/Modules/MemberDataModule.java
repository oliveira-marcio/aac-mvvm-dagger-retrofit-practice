package com.androidtutz.anushka.memberapp.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.androidtutz.anushka.memberapp.models.MemberDataManager;
import com.androidtutz.anushka.memberapp.models.NetworkManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by K. A. ANUSHKA MADUSANKA on 1/25/2018.
 */
@Module
public class MemberDataModule {

    private Context context;

    public MemberDataModule(Context context) {
        this.context = context;
    }


    @Singleton @Provides
    public Context provideContext(){
        return context;
    }

    @Singleton @Provides
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    @Singleton @Provides
    public NetworkManager provideNetworkManager(){

        return new NetworkManager();
    }

    @Provides
    @Named("local")
    @Singleton
    MemberDataManager provideMemberDataManagerLocal(SharedPreferences sharedPreferences){

        return new MemberDataManager(sharedPreferences);


    }

    @Provides
    @Named("online")
    @Singleton
    MemberDataManager provideMemberDataManagerOnline(SharedPreferences sharedPreferences,NetworkManager networkManager){

        return new MemberDataManager(sharedPreferences,networkManager);


    }



}
