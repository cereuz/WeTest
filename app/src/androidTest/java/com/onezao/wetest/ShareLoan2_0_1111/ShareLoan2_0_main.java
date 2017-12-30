package com.onezao.wetest.ShareLoan2_0_1111;

import android.support.test.uiautomator.UiDevice;

/**
 * Created by zneo on 2017/12/1.
 */

public class ShareLoan2_0_main {

    //测试Loan2.0主入口。
    public static void testHere(UiDevice device){
        //测试登录注册
        ShareLoan2_0_main.testLoginAndRegister(device);
        //调用测试共享现金的方法
        ShareLoan2_0_main.testNotLoginLoan2_0(device);
       /* //打开蝌蚪APP
        TestUse1026.openAPP(context,"com.gcs.mcj.chat");*/
    }


    //测试共享现金2.0，【登录注册】
    public static void testLoginAndRegister(UiDevice device){
        //从启动页到借款页面，需要一点缓冲时间。不然会空指针异常。页面切换之间都需要给出缓冲时间。
        //打开共享现金APP
        TestUse1026.openAPP(ShareLoan2_0.packageName);
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //允许读取位置信息。
        TestUse1026.btnAllow(device);
        //启动页，只在第一次安装的时候才调用这个方法
        ShareLoan2_0.slogan(device);
        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        //点击借款，进入借款页面
        TestUse1026.getUiObject2(device, ShareLoan2_0.my_IV).click();
        TestUse1026.getUiObject2(device, ShareLoan2_0.loan_TV).click();
    }


    //测试共享现金2.0  ，【未登录状态】
    public static void testNotLoginLoan2_0(UiDevice device){
        //从启动页到借款页面，需要一点缓冲时间。不然会空指针异常。页面切换之间都需要给出缓冲时间。
        //打开共享现金APP
        TestUse1026.openAPP(ShareLoan2_0.packageName);
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //允许读取位置信息。
        TestUse1026.btnAllow(device);
        //启动页，只在第一次安装的时候才调用这个方法
        ShareLoan2_0.slogan(device);

        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        //首页的操作
        ShareLoan2_0.prepare(device);
        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        //点击进入借款页面
        ShareLoan2_0.borrow(device);
        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        //点击进入发现页面
        ShareLoan2_0.discover(device);
        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        //截图功能
        TestUse1026.snapPic(device,ShareLoan2_0.packageName);
        //点击进入个人中心
        ShareLoan2_0.personal(device);
    }

}
