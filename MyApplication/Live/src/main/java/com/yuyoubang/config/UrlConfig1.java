package com.yuyoubang.config;

/**
 * Created by LiJun on 2017/10/26.
 */

public class UrlConfig1 {
    public static String TestHostUrl;

    // 0测试环境
    public static final int Test = 0;
    // 1线上环境
    public static final int Online = 1;

    static {
        switch (Online) {
            case Test:
                TestHostUrl = "http://59.110.21.9:28001/";
                break;
            case Online:
                TestHostUrl = "http://59.110.21.9:28001/";
                break;
        }
    }


    public final static String API_V1_0_TEST = "contact/company/list.json";
}
