package com.a14tclc.ngocanh.tutorial.service;

public interface Callback<T> {
    void onSuccess(T result);

    void onError(Throwable what);
}

