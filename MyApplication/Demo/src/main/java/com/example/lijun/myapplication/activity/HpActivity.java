package com.example.lijun.myapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.yuyoubang.R;
import com.yuyoubang.activity.base.BaseActivity;
import com.yuyoubang.adapter.HomeAdapter;
import com.yuyoubang.bean.Live;
import com.yuyoubang.network.RetrofitManager;
import com.yuyoubang.network.api.HomeApi;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by LiJun on 2017/10/25.
 */

public class HpActivity extends BaseActivity {
    RecyclerView rv;
    HomeAdapter adapter;
    @Override
    protected void initTitleBar(HeaderBuilder builder) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getData();
    }
        private void initView(){
             rv=getViewById(R.id.rv);
}
    @Override
    protected int getContentResId() {
        return R.layout.fp;
    }

    private void getData(){
        adapter=new HomeAdapter(this);
        HomeApi homeApi= RetrofitManager.getTestRetrofit().create(HomeApi.class);
        FormBody body=new FormBody.Builder()
                .add("type","0")
                .add("page","1")
                .build();
        Call<Live> testCall=homeApi.live_find(body);
        testCall.enqueue(new Callback<Live>() {
            @Override
            public void onResponse(Call<Live> call, Response<Live> response) {
                //适配器加载内容
                adapter.addData(response.body().getResult().getList());
            }

            @Override
            public void onFailure(Call<Live> call, Throwable t) {
                Toast.makeText(HpActivity.this,"网络连接失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
