package com.androidtutz.anushka.didemo;

import dagger.Component;

@Component(modules = MemoryCardModule.class)
public interface SmartPhoneComponent {
    SmartPhone getSmartPhone();
}
