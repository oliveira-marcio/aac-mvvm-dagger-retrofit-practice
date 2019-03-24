package com.androidtutz.anushka.memberapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Inject
    MemberDataManager memberDataManager;


    @BindView(R.id.etMemberId)
    EditText memberId;
    @BindView(R.id.btnSubmit)
    Button submitButton;
    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        App.getApp().getMemberAppComponent().inject(this);
    }

    @OnClick(R.id.btnSubmit)
    public void onClick() {
        if ((memberId.getText().toString().equals(""))) {
            Toast.makeText(getApplicationContext(), "Member ID is empty", Toast.LENGTH_SHORT).show();
        } else {

            String input = memberId.getText().toString();


            // String result=new MemberDataManager().checkMemberStatus(input);
            String result = memberDataManager.checkMemberStatus(input);

            tvResult.setText(result);
//            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
        }
    }
}
