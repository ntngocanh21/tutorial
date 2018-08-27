package com.a14tclc.ngocanh.tutorial.service;

import com.a14tclc.ngocanh.tutorial.data.model.LoginResponse;
import retrofit2.Call;
import retrofit2.Response;

public class LoginServiceImpl implements LoginService{

    @Override
    public void getUser(final Callback<LoginResponse> callback) {

        APILogin apiLogin = APIClient.getClient().create(APILogin.class);
        Call<LoginResponse> call = apiLogin.getUser();
        call.enqueue(new retrofit2.Callback<LoginResponse>(){
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
