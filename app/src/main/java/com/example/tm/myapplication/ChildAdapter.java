package com.example.tm.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;


public class ChildAdapter extends PagerAdapter {
    private List<ImageView> data;
    private Context context;
    private static final String TAG = "ChildAdapter";

    public ChildAdapter(List<ImageView> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        //规定viewpager的最大页数
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.i(TAG, "destroyItem: 销毁了一个item");
        container.removeView(data.get((position)%data.size()));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//position是0-4
        Log.i(TAG, "instantiateItem: 新建了一个item");
        container.addView(data.get(position%data.size()));
        return data.get(position%data.size());
    }
}
