package com.example.lijun.myapplication.config;

/**
 * Created by LiJun on 2017/10/26.
 */

public class UrlConfig {
    public static String TestHostUrl;

    // 0测试环境
    public static final int Test = 0;
    // 1线上环境
    public static final int Online = 1;

    static {
        switch (Online) {
            case Test:
                TestHostUrl = "http://121.42.26.175:14444/";
                break;
            case Online:
                TestHostUrl = "http://121.42.26.175:14444/";
                break;
        }
    }


    public final static String LIVEFIND= "live/find.json";
}
