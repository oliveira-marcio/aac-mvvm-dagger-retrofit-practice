package com.androidtutz.anushka.didemo;

import dagger.Component;

@Component(modules = {MemoryCardModule.class, NCBatteryModule.class})
public interface SmartPhoneComponent {

    void inject(MainActivity mainActivity);
}
