package com.onezao.wetest.testutils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zz on 2017/10/26.
 */

public class TestUse1026 {
    //Zao应用的包名
    public static String PACKAGENAMEZAO = "com.onezao.onezao.zao";
    public static String BTN_ALLOW = "com.huawei.systemmanager:id/btn_allow";

    //睡眠，延后几秒钟发送
    public static void sleep(int mint) {
        try {
            Thread.sleep(mint);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //获取系统当前时间
    public static String getSystemTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        //获取时间，
/*      SimpleDateFormat    sDateFormat    =   new SimpleDateFormat("yyyy-MM-dd    hh:mm:ss");
        String  date    =    sDateFormat.format(new java.util.Date());*/
        return str;
    }

    //找到并打开指定app
    public static void openAPP(String packageN) {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageN);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    //刷新APP页面
    public static void refreshAPP(Context context) {

    }

    //下拉APP刷新
    public static void pullToRefresh() {

    }

    //复制文件
    public static long copyFile(String p1, String p2) {
        long time = new Date().getTime();
        int length = 1024;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(p1));
            FileOutputStream fos = new FileOutputStream(new File(p2));
            byte[] buffer = new byte[length];
            while (true) {
                int ins = fis.read(buffer);
                if (ins == -1) {
                    fis.close();
                    fos.flush();
                    fos.close();
                    return new Date().getTime() - time;
                } else {
                    fos.write(buffer, 0, ins);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }


    //APP截图,
    public static void snapPic(UiDevice device,String fileName){
        String path2 = Environment.getExternalStorageDirectory().getPath()+"/"+ fileName.substring(fileName.lastIndexOf(".")+1,fileName.length())+TestUse1026.getSystemTime()+".png";
        device.takeScreenshot(new File(path2));
        sleep(2000);
    }

    //获取屏幕的分辨率，高
    public static int getScreenHeight(UiDevice device){
        int displayHeight =device.getDisplayHeight();
        return displayHeight;
    }

    //获取屏幕的分辨率，宽
    public static int getScreenWidth(UiDevice device){
        int displayWidth =device.getDisplayWidth();
        return  displayWidth;
    }

    //封装找到控件的方法
    public static UiObject2 getUiObject2(UiDevice device,String resId) {
        UiObject2 UiOb2 = device.findObject(By.res(resId));
        return  UiOb2;
    }
    //封装找到多个相同控件的方法
    public static List<UiObject2> getUiObject2s(UiDevice device,String resId) {
        List<UiObject2>  UiOb2s = device.findObjects(By.res(resId));
        return  UiOb2s;
    }

    //运去读取位置信息
    public static void btnAllow(UiDevice device){
        if(TestUse1026.getUiObject2(device,BTN_ALLOW) != null){
        TestUse1026.getUiObject2(device,BTN_ALLOW).click();
      }
    }
}
