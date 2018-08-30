package com.tcs.raghu.retrofitdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tcs.raghu.retrofitdemo.R;
import com.tcs.raghu.retrofitdemo.model.Category;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<Category> mData;



public CategoryAdapter(Context context,List<Category> mData){
    this.mContext = context;
    this.mData = mData;
  mLayoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.catogory_list, null);
        }
        Category mCategory = mData.get(i);
        TextView catName = (TextView) view.findViewById(R.id.name);
        ImageView catimg = (ImageView)view.findViewById(R.id.img);
        catName.setText(mCategory.getCatName());
        Picasso.get().load(mCategory.getImage()).into(catimg);
        return view;
    }
}
