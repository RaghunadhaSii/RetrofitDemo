package com.tcs.raghu.retrofitdemo.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.tcs.raghu.retrofitdemo.R;
import com.tcs.raghu.retrofitdemo.adapter.CategoryAdapter;
import com.tcs.raghu.retrofitdemo.model.Category;
import com.tcs.raghu.retrofitdemo.model.CategoryResponse;
import com.tcs.raghu.retrofitdemo.services.CategoryService;
import com.tcs.raghu.retrofitdemo.utils.HttpCallResponse;
import com.tcs.raghu.retrofitdemo.utils.SpinnerManager;

import java.util.List;

import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    Context mContext;
    private CategoryAdapter mCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.mList);
        fatchCatogory(mContext);
    }


    public void fatchCatogory(final Context mContext){
       SpinnerManager.showSpinner(MainActivity.this,"loding");
        CategoryService.getCategorys(mContext, new HttpCallResponse() {
            @Override
            public void onSuccess(Object response) {

                retrofit2.Response<CategoryResponse> mList = (retrofit2.Response<CategoryResponse>) response;
                CategoryResponse mCategoryResponse = mList.body();
                List<Category> mData = mCategoryResponse.getCategory();
                mCategoryAdapter = new CategoryAdapter(MainActivity.this,mData);
                mListView.setAdapter(mCategoryAdapter);
                SpinnerManager.hideSpinner(MainActivity.this);
            }

            @Override
            public void onFailure(Throwable throwable) {
                SpinnerManager.hideSpinner(MainActivity.this);

            }
        });

    }


}
