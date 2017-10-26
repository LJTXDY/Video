package com.example.lijun.myapplication.network.api;


import com.yuyoubang.config.UrlConfig;
import com.yuyoubang.network.HttpClient;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * date: Created xiaoyuan on 16/11/05.
 */
public interface TestApi {

    @Headers(HttpClient.CACHE_CONTROL_AGE + HttpClient.CACHE_SHORT)
    @POST(UrlConfig.API_V1_0_TEST)
    Call<Object> test();

}
