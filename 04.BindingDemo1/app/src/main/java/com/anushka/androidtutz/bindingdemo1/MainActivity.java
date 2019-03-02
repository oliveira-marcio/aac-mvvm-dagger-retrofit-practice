package com.anushka.androidtutz.bindingdemo1;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.anushka.androidtutz.bindingdemo1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private TextView nameText;
    private TextView emailText;

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setStudent(getCurrentStudent());

    }

    private Student getCurrentStudent(){

        Student student = new Student();
        student.setStudentName("Alex");
        student.setStudentEmail("alex@gmail.com");
        return student;

    }
}
