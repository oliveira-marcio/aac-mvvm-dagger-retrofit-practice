package com.androidtutz.anushka.findtheday;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ChooserModule.class)
public interface ApplicationComponent {

    void inject(DayFragment dayFragment);
}
