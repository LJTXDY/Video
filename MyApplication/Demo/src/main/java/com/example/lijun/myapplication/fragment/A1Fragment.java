package com.example.lijun.myapplication.fragment;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lijun.myapplication.R;
import com.example.lijun.myapplication.adapter.HomeAdapter;
import com.example.lijun.myapplication.adapter.VideoAdapter;
import com.example.lijun.myapplication.bean.Login;
import com.example.lijun.myapplication.interfaces.LeginApi;
import com.example.lijun.myapplication.network.RetrofitManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
    SwipeRefreshLayout sp;
    ListView lv;
    View view;
    Login bean;
   // VideoAdapter adapter;
    HomeAdapter adapter;
    ArrayList<HashMap<String,Object>> alist=new ArrayList<>();

//    Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            if (msg.what==0x111){
//                adapter.updateAdapter(bean);
//                sp.setRefreshing(false);
//            }
//        }
//    };
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
                Toast.makeText(getActivity(),"正在刷新...",Toast.LENGTH_SHORT).show();
                ///handler.sendEmptyMessageDelayed(0x111,3000);
            }
        });

        lv= (ListView) view.findViewById(R.id.lv1);
        //getDateByType();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.notifyDataSetChanged();
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
                //适配器加载内容
               // adapter.addData(response.body().getResult().getList());
                adapter.addData(response.body().getResult().getList());
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(getActivity(),"网络连接失败",Toast.LENGTH_SHORT).show();
            }
        });
    }


//    void getDateByType(){
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    URL url=new URL("http://121.42.26.175:14444/live/find.json");
//                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
//                    connection.setRequestMethod("POST");
//                    // 发送POST请求必须设置如下两行
//                    connection.setDoOutput(true);
//                    connection.setDoInput(true);
//                    connection.setConnectTimeout(10000);
//                    connection.setReadTimeout(10000);
//                    connection.setRequestProperty("type","0");
//                    connection.setRequestProperty("page","1");
//                    connection.connect();
//                    if (connection.getResponseCode()==200){
//                        InputStream is=connection.getInputStream();
//                        ByteArrayOutputStream bs=new ByteArrayOutputStream();
//                        byte[] buffer=new byte[512];
//                        int length;
//                        while ((length=is.read(buffer))!=-1){
//                            bs.write(buffer,0,length);
//                            bs.flush();
//                        }
//                        bean=new Gson().fromJson(bs.toString()
//                                ,new TypeToken<Login>(){}.getType());
//                        Log.d("SKT",bs.toString());
//
//                        adapter=new VideoAdapter(getActivity(),bean,alist);
//                        getActivity().runOnUiThread(new Thread(){
//                            @Override
//                            public void run() {
//                                lv.setAdapter(adapter);
//                            }
//                        });
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//    }
}






















































