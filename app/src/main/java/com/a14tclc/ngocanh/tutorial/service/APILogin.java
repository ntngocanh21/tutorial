package com.a14tclc.ngocanh.tutorial.service;

import com.a14tclc.ngocanh.tutorial.data.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APILogin {

    @GET("/api")
    Call<LoginResponse> getUser();
}
