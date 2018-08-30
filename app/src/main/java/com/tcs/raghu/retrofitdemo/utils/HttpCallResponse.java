package com.tcs.raghu.retrofitdemo.utils;

public interface HttpCallResponse {
    void onSuccess(Object response);
    void onFailure(Throwable throwable);
}
