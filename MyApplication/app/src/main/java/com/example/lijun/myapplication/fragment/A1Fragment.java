package com.example.lijun.myapplication.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lijun.myapplication.R;

/**
 * Created by LiJun on 2017/10/25.
 */

public class A1Fragment extends Fragment {
    SwipeRefreshLayout sp;
    ListView lv;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fp_a_1,null);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sp= (SwipeRefreshLayout) view.findViewById(R.id.sp1);
        lv= (ListView) view.findViewById(R.id.lv1);
        //设置刷新控件的颜色
        sp.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_bright,null),
                getResources().getColor(android.R.color.holo_green_dark,null),
                getResources().getColor(android.R.color.holo_red_light,null),
                getResources().getColor(android.R.color.holo_orange_dark,null)
        );
        //设置刷新控件的背景颜色
        sp.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.colorAccent,null));
        //给刷新控件设置监听
        sp.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {

            }
        });

    }
}






















































