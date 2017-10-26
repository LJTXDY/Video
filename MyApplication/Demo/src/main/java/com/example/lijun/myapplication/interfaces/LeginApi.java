package com.example.lijun.myapplication.interfaces;

import com.example.lijun.myapplication.bean.Login;
import com.example.lijun.myapplication.config.UrlConfig;

import okhttp3.FormBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by LiJun on 2017/10/25.
 */

public interface LeginApi {
    @POST(UrlConfig.LIVEFIND)
    Call<Login> query(@Body FormBody body);

}
