package com.marcio.postapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.marcio.postapp.R;
import com.marcio.postapp.model.User;
import com.marcio.postapp.service.PostAppService;
import com.marcio.postapp.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText userEmail;
    private EditText password;
    private Button submitButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        resultTextView = findViewById(R.id.tv_result);
        submitButton = findViewById(R.id.btn_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });
    }

    private void postData() {
        User user = new User();
        user.setUserEmail(userEmail.getText().toString());
        user.setPassword(password.getText().toString());

        Log.i("responseTest", "************************ before id: " + user.getId());

        PostAppService postAppService = RetrofitInstance.getService();
        Call<User> call = postAppService.getResult(user);

        userEmail.setText("");
        password.setText("");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User returnedUser = response.body();
                resultTextView.setText("Id is: " + returnedUser.getId());
                Log.i("responseTest", "************************ after id: " + returnedUser.getId());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
