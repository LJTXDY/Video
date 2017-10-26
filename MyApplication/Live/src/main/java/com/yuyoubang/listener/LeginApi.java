package com.yuyoubang.listener;



import com.yuyoubang.bean.Login;
import com.yuyoubang.config.UrlConfig;

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
