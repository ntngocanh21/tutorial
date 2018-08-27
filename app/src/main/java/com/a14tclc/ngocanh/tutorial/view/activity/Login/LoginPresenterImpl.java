package com.a14tclc.ngocanh.tutorial.view.activity.Login;

import android.util.Log;

import com.a14tclc.ngocanh.tutorial.data.model.LoginResponse;
import com.a14tclc.ngocanh.tutorial.data.model.User;
import com.a14tclc.ngocanh.tutorial.service.Callback;
import com.a14tclc.ngocanh.tutorial.service.LoginService;
import com.a14tclc.ngocanh.tutorial.service.LoginServiceImpl;

public class LoginPresenterImpl implements LoginPresenter {

    private LoginService loginService;
    private LoginView loginView;


    public LoginPresenterImpl(LoginView loginView) {
        loginService = new LoginServiceImpl();
        this.loginView = loginView;
    }

    @Override
    public void login(final String username, String password) {
//        Log.i("TAG", "Username: " + username);
//        Log.i("TAG", "Password: " + password);
        loginService.getUser(new Callback<LoginResponse>() {
            @Override
            public void onSuccess(LoginResponse result) {
                boolean check = false;
                for (User user : result.getUserList()){
                    Log.i("TAG", "Username: " + user.getUsername());
                    if ((user.getUsername()).equals(username)){
                        check = true;
                    }
                }
                if (check){
                    loginView.showToast("Login successfully!!!");
                }
                else {
                    loginView.showToast("Username or password is incorrect!!!");
                }
            }

            @Override
            public void onError(Throwable what) {
                //check
                loginView.showToast("FALSE!!!");
            }
        });
    }
}
