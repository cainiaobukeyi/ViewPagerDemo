package com.example.tm.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{


    ViewPager parentViewpager;
    List<Fragment> fragments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private static final String TAG = "MainActivity";
    private void initData() {
        fragments=new ArrayList<>();
        FirstFragment firstFragment=new FirstFragment();
        SecondFragment secondFragment=new SecondFragment();
        ThirdFragment thirdFragment=new ThirdFragment();
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(thirdFragment);
        ParentAdapter adapter=new ParentAdapter(getSupportFragmentManager(),fragments);
        parentViewpager.setAdapter(adapter);
    }


    private void initView() {
        parentViewpager= (ViewPager) findViewById(R.id.parent_viewPager);
    }
}
