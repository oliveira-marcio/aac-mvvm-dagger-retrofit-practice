package com.androidtutz.anushka.memberapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.androidtutz.anushka.memberapp.models.MessageGenerator;
import com.androidtutz.anushka.memberapp.modules.MessagesModule;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {

    @BindView(R.id.tvResultAtWelcome)
    TextView tvResultAtWelcome;

    @Inject
    MessageGenerator messageGenerator;
    @BindView(R.id.tvMessage)
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        (App.getApp().getMemberAppComponent())
                .newWelcomeActivityComponent(new MessagesModule())
                .inject(this);

        tvResultAtWelcome.setText(getIntent().getStringExtra("result"));

        tvMessage.setText(messageGenerator.getWelcomeMessage());


    }
}
