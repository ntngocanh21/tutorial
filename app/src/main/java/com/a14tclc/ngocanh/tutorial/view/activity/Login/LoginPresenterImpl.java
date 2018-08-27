package com.a14tclc.ngocanh.tutorial.view.activity.Login;

import android.util.Log;

import com.a14tclc.ngocanh.tutorial.data.model.LoginResponse;
import com.a14tclc.ngocanh.tutorial.data.model.User;
import com.a14tclc.ngocanh.tutorial.service.APIClient;
import com.a14tclc.ngocanh.tutorial.service.APILogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenterImpl implements LoginPresenter {


    private LoginView loginView;
    private APIClient apiClient;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;

        if (this.apiClient == null) {
            this.apiClient = new APIClient();
        }
    }

    @Override
    public void login(final String username, String password) {
        apiClient.getClient().create(APILogin.class).getUser()
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        boolean check = false;
                        for (User user : response.body().getUserList()) {
                            Log.i("TAG", "Username: " + user.getUsername());
                            if ((user.getUsername()).equals(username)) {
                                check = true;
                            }
                        }
                        if (check) {
                            loginView.showToast("Login successfully!!!");
                        } else {
                            loginView.showToast("Username or password is incorrect!!!");
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.i("TAG", "Errors: " + t.getMessage());
                    }
                });
    }
}