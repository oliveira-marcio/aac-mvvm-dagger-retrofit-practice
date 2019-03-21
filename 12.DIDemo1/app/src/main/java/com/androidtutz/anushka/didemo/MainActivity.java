package com.androidtutz.anushka.didemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Battery battery = new Battery();
        MemoryCard memoryCard = new MemoryCard();

        ServiceProvider serviceProvider = new ServiceProvider();
        SIMCard simCard = new SIMCard(serviceProvider);

        // Constructor injection
        SmartPhone smartPhone = new SmartPhone(battery,memoryCard,simCard);

        // Method injection
        smartPhone.setBattery(battery);

        // Field injection
        smartPhone.battery = battery;

        smartPhone.makeACall();



    }
}
