package com.example.tm.myapplication;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by TM on 2016/9/12.
 */

public class ParentAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    public ParentAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        this.data=data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        int ret=0;
        if(data!=null){
            ret=data.size();
        }
        return ret;
    }
}
