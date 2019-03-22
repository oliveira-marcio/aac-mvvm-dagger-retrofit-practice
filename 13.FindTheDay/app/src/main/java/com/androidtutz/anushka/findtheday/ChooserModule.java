package com.androidtutz.anushka.findtheday;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ChooserModule {

    @Singleton
    @Provides
    DayChooser provideDayChooser(){

        return new DayChooser();
    }
}
