package com.tcs.raghu.retrofitdemo.services;

import android.content.Context;

import com.tcs.raghu.retrofitdemo.model.CategoryResponse;
import com.tcs.raghu.retrofitdemo.utils.HttpCallResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public class CategoryService extends BaseService {
    public static void getCategorys(final Context mContext, final HttpCallResponse mHttpCallResponse){
        CategoryInterface mCategoryInterface = retrofit.create(CategoryInterface.class);
        Call<CategoryResponse> mCall = mCategoryInterface.getCatogorys();
        mCall.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if(response.isSuccessful()){
                    mHttpCallResponse.onSuccess(response);
                }

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                mHttpCallResponse.onFailure(t);

            }
        });

    }

    public interface CategoryInterface {
        @Headers("Content-Type: application/json; charset=utf-8")
        @GET("category_list")
        Call<CategoryResponse> getCatogorys();
    }
}





