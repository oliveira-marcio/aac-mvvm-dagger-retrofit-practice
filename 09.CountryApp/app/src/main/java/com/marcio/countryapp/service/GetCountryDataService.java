package com.marcio.countryapp.service;

import com.marcio.countryapp.model.Info;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {

    @GET("country/get/all")
    Call<Info> getResultes();
}
