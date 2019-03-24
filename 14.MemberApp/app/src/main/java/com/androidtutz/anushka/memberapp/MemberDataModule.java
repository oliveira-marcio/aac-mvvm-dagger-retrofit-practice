package com.androidtutz.anushka.memberapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

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

    @Provides
    @Singleton
    public Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    public NetworkManager provideNetworkManager(){
        return new NetworkManager();
    }

    @Provides
    @Named("local")
    @Singleton
    MemberDataManager provideMemberDataManagerLocal(SharedPreferences sharedPreferences) {

        return new MemberDataManager(sharedPreferences);


    }

    @Provides
    @Named("online")
    @Singleton
    MemberDataManager provideMemberDataManagerOnline(SharedPreferences sharedPreferences, NetworkManager networkManager) {

        return new MemberDataManager(sharedPreferences, networkManager);


    }

}
