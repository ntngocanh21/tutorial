package com.a14tclc.ngocanh.tutorial.service;

import com.a14tclc.ngocanh.tutorial.data.model.LoginResponse;

public interface LoginService {
    void getUser(Callback<LoginResponse> callback);
}
