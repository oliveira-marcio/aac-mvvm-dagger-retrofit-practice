package com.androidtutz.anushka.memberapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutz.anushka.memberapp.models.MemberDataManager;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Inject @Named("local")
    MemberDataManager memberDataManager;

    @Inject  @Named("dd-MMM-yyyy")
    String currentDate;


    @BindView(R.id.etMemberId)
    EditText etMemberId;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    @BindView(R.id.tvResult)
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        App.getApp().getMemberAppComponent().inject(this);

        tvResult.setText(currentDate);


    }

    @OnClick(R.id.btnSubmit)
    public void onClick() {
        if ((etMemberId.getText().toString().equals(""))) {
            Toast.makeText(getApplicationContext(), "Member ID is empty", Toast.LENGTH_SHORT).show();
        } else {

            String input = etMemberId.getText().toString();


            // String result=new MemberDataManager().checkMemberStatus(input);
            String result = memberDataManager.checkMemberStatus(input);


             if(result.equals("Access Denied")) {
                 // Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                 tvResult.setText(result);

             }else{

                 Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
                 intent.putExtra("result",result);
                 startActivity(intent);
             }
        }

    }
}
