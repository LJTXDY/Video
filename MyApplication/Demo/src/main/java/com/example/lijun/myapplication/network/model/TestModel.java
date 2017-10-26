package com.example.lijun.myapplication.network.model;




import com.example.lijun.myapplication.network.BaseCallback;
import com.example.lijun.myapplication.network.RetrofitManager;
import com.example.lijun.myapplication.network.api.TestApi;
import com.example.lijun.myapplication.utils.LogUtils;
import com.example.lijun.myapplication.utils.ToastUtils;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * date: Created hongchen on 16/11/05.
 */
public class TestModel {

    private static TestApi testApi = RetrofitManager.getTestRetrofit().create(TestApi.class);

    public static void test() {
        Call<Object> testCall = testApi.test();
        testCall.enqueue(new BaseCallback<Object>() {

            public void onResponse(Call<Object> call, Response<Object> response) {
                LogUtils.e("call ---> " + call.toString());
                Object result = response.body();
                LogUtils.e("response ---> " + result.toString());
            }


            public void onFailure(Call<Object> call, Throwable throwable) {
                throwable.printStackTrace();
                if (throwable instanceof HttpException || throwable instanceof UnknownHostException) {
                    ToastUtils.showShort("请检查您的网络连接");
                }
            }
        });
    }
}
