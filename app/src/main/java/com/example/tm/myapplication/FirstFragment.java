package com.example.tm.myapplication;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";
    private View view;
    private ChildViewpager childViewpager;
    private List<ImageView> data;
    private int[] imageArray={R.mipmap.first,R.mipmap.second,R.mipmap.third,R.mipmap.forth,R.mipmap.fifth};
    private int maxCount=5000;

    //启动一个定时器
    private Handler handler=new Handler();
    private Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Log.i(TAG, "run: 进入了定时器");
            childViewpager.setCurrentItem(maxCount++);
            handler.postDelayed(this,2000);//这一句是表示开启定时器的循环
        }
    };

    public FirstFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);
        childViewpager= (ChildViewpager) view.findViewById(R.id.child_viewPager);
        initData();
        return view;
    }

    private void initData() {
        data=new ArrayList<>();
        for(int i=0;i<5;i++){
            ImageView imageView=new ImageView(getActivity());
            imageView.setBackgroundResource(imageArray[i]);
            final int j=i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "点击"+j, Toast.LENGTH_SHORT).show();
                }
            });
            data.add(imageView);
        }
        ChildAdapter adapter=new ChildAdapter(data,getActivity());
        childViewpager.setAdapter(adapter);
        childViewpager.setCurrentItem(maxCount);//设置一个比较大的数用来为viewpager初始化第一个页面
        childViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i(TAG, "onPageScrolled: position"+position);
                handler.removeCallbacks(runnable);
                maxCount=position;//由于setCurrent（）方法每次只能比原来的position多一个，所以将现在的position记录下来，为累加做初值
                handler.postDelayed(runnable,2000);
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable,2000);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable,2000);
    }
}
