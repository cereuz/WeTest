package com.onezao.wetest.testutils;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zz on 2017/10/26.
 */

public class TestUse1026 {
    //睡眠，延后几秒钟发送
    public static void sleep(int mint){
        try {
            Thread.sleep(mint);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //获取系统当前时间
    public static String getSystemTime(){

        SimpleDateFormat formatter    =   new SimpleDateFormat ("yyyy年MM月dd日 HH:mm:ss");
        Date curDate    =   new Date(System.currentTimeMillis());//获取当前时间
        String    str    =    formatter.format(curDate);
        //获取时间，
/*      SimpleDateFormat    sDateFormat    =   new SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
        String  date    =    sDateFormat.format(new java.util.Date());*/
        return str;
    }

    //找到并打开指定app
    public static void openAPP(Context context){
        context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.gcs.mcj.chat");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}
