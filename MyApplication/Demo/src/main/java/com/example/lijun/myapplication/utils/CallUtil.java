package com.example.lijun.myapplication.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * date: Created xiaoyuan on 16/11/05.
 */
public class CallUtil {
    public static void call(Context context, String callNum) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);   //android.intent.action.DIAL
        intent.setData(Uri.parse("tel:" + callNum));
        context.startActivity(intent);
    }
}
