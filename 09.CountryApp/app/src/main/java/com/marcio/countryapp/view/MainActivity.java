package com.marcio.countryapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.marcio.countryapp.R;
import com.marcio.countryapp.model.Info;
import com.marcio.countryapp.model.Result;
import com.marcio.countryapp.service.GetCountryDataService;
import com.marcio.countryapp.service.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    public Object getCountries() {
        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Info> call = getCountryDataService.getResults();
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Info info = response.body();
                if (info != null && info.getRestResponse() != null) {
                    results = info.getRestResponse().getResult();
                    for (Result result : results) {
                        Log.i("testing", "****************" + result.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });

        return results;
    }
}
