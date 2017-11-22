package com.onezao.wetest.testutils;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    public static void openAPP(String packageN){
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageN);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    //刷新APP页面
    public static void refreshAPP(Context context){

    }

    //下拉APP刷新
    public static void pullToRefresh(){

    }

    //复制文件
    public static long copyFile(File f1,File f2) throws Exception{
        long time=new Date().getTime();
        int length=1024;
        FileInputStream fis=new FileInputStream(f1);
        FileOutputStream fos=new FileOutputStream(f2);
        byte[] buffer=new byte[length];
        while(true){
            int ins=fis.read(buffer);
            if(ins==-1){
                fis.close();
                fos.flush();
                fos.close();
                return new Date().getTime()-time;
            }else
                fos.write(buffer,0,ins);
        }
    }

    //APP截图,暂时未实现
    public static void snapPic(UiDevice device){
        // Simulate a short press on the HOME button.
        /*device.pressHome() ;
        sleep(1000) ;*/
        //创建文件
        String path = Environment.getExternalStorageDirectory().getPath() + "/cool.png";
//        File f = new File("/data/local/tmp/Screenshot.png") ;
        device.takeScreenshot(new File("/mnt/sdcard/Screenshot.png") , 0, 50) ;
        device.takeScreenshot(new File(path));
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
}
