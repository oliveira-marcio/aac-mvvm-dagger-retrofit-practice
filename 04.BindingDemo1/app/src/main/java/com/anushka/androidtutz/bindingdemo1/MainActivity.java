package com.anushka.androidtutz.bindingdemo1;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.anushka.androidtutz.bindingdemo1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private TextView nameText;
    private TextView emailText;

    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setStudent(getCurrentStudent());

        handlers = new MainActivityClickHandlers(this);
        activityMainBinding.setClickHandler(handlers);
    }

    private Student getCurrentStudent(){

        Student student = new Student();
        student.setStudentName("Alex");
        student.setStudentEmail("alex@gmail.com");
        return student;

    }

    public class MainActivityClickHandlers {
        Context context;

        public MainActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onEnrollButtonClick(View view){
            Toast.makeText(context, "Enroll Clicked", Toast.LENGTH_SHORT).show();
        }

        public void onCancelButtonClick(View view){
            Toast.makeText(context, "Cancel Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
