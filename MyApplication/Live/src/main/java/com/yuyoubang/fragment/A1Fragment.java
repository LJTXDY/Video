package com.yuyoubang.fragment;


import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;


import com.yuyoubang.R;
import com.yuyoubang.adapter.HomeAdapter;
import com.yuyoubang.bean.Login;
import com.yuyoubang.listener.LeginApi;
import com.yuyoubang.network.RetrofitManager;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LiJun on 2017/10/25.
 */

public class A1Fragment extends Fragment {
    RecyclerView rv;
    View view;
    HomeAdapter adapter;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fp_a_1,null);
        return view;
    }


    @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.M)
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter=new HomeAdapter(getActivity());
        rv= (RecyclerView) view.findViewById(R.id.rv);
        //设置recyclerview布局的排列方式
        LinearLayoutManager layout=new LinearLayoutManager(getActivity());
        layout.setOrientation(OrientationHelper.VERTICAL);
        rv.setLayoutManager(layout);
        rv.setAdapter(adapter);
        //添加分割线

        getData();
    }


    private void getData(){

        LeginApi leginApi= RetrofitManager.getTestRetrofit().create(LeginApi.class);
        FormBody body=new FormBody.Builder()
                .add("type","0")
                .add("page","1")
                .build();
        Call<Login> testCall=leginApi.query(body);
        testCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                //获取数据
                adapter.addData(response.body().getResult().getList());
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getActivity(),"网络连接失败",Toast.LENGTH_SHORT).show();
            }
        });
    }



}






















































