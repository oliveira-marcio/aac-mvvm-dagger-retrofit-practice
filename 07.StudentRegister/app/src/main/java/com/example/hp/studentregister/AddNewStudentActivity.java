package com.example.hp.studentregister;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.hp.studentregister.databinding.ActivityAddNewStudentBinding;

public class AddNewStudentActivity extends AppCompatActivity {

    private ActivityAddNewStudentBinding activityAddNewStudentBinding;
    private AddNewActivityClickHandlers handlers;
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_student);

        activityAddNewStudentBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_student);

        student = new Student();
        activityAddNewStudentBinding.setStudent(student);

        handlers = new AddNewActivityClickHandlers(this);
        activityAddNewStudentBinding.setClickHandler(handlers);
    }

    public class AddNewActivityClickHandlers {
        Context context;

        public AddNewActivityClickHandlers(Context context) {
            this.context = context;
        }

        public void onSubmitClicked(View view) {
            if (student.getName() == null) {
                Toast.makeText(getApplicationContext(), "Name field cannot be empty", Toast.LENGTH_LONG).show();
            } else {
                Intent intent = new Intent();
                intent.putExtra("NAME", student.getName());
                intent.putExtra("EMAIL", student.getEmail());
                intent.putExtra("COUNTRY", student.getCountry());
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }
}
