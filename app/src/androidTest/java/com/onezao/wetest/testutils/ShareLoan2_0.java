package com.onezao.wetest.testutils;

import android.content.Context;
import android.graphics.Rect;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import java.util.List;

/**
 * Created by zneo on 2017/11/22.
 */

public class ShareLoan2_0 {
    //共享现金2.0包名
    public static String packageName = "com.gcs.wang.loan";
    //启动页的“我要借款”按钮
    public static String button_slogan_id = "com.gcs.wang.loan:id/tv";
    //借款页面的“可借金额”滑动选择框
    public static String money_can_borrow = "com.gcs.wang.loan:id/loan_stringScrollPicker";
    //可借日期的选择
    public static String magic_indicator = "com.gcs.wang.loan:id/magic_indicator";
    //使用优惠券，点击查看优惠券，然后选择使用优惠券
    public static String discount_LL = "com.gcs.wang.loan:id/discount_LL";
    //点击借款费用的问号
    public static String loan_repayMore_IV = "com.gcs.wang.loan:id/loan_repayMore_IV";
    //点击立即借款
    public static String loan_Btn = "com.gcs.wang.loan:id/loan_Btn";
    //点击底部的重复使用View
    public static String loan_RecyclerView = "com.gcs.wang.loan:id/loan_RecyclerView";
    //定义可以滑动的对象
    public static UiScrollable uis ;
    //启动页，只在第一次安装的时候才调用这个方法
    public static void slogan(UiDevice device){
        uis = new UiScrollable(new UiSelector().scrollable(true));
        try {
            //设置水平滚动
            uis.setAsHorizontalList();
            uis.scrollForward();
            uis.scrollBackward();
            uis.scrollToEnd(3);
            uis.scrollToBeginning(3);
            uis.scrollToEnd(4);
          //点击我要借款
            UiObject2 slogan_btn = device.findObject(By.res(button_slogan_id));
            slogan_btn.click();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    //借款页面的点击事件
    public static void  borrow(UiDevice device){
        //顶部的可借金额，动画效果，未能监听。     不能点击，不能滑动。通过device左边来点击
        UiObject2 money_can_borrow = device.findObject(By.res(ShareLoan2_0.money_can_borrow));
        Rect viewRect = money_can_borrow.getVisibleBounds();
        int x = viewRect.right;
        int y = viewRect.bottom;
        for(int i = 0;i < 10;i++){
            device.click(x/2-x/5,y-20);
            //间隔一秒钟点击一次
           // TestUse1026.sleep(1000);
        }

        //滑动选择框  ，  这个点击事件暂时没有实现。
      /*  uis = new UiScrollable(new UiSelector().scrollable(true).resourceId(ShareLoan2_0.money_can_borrow));
        uis.setAsHorizontalList();
        try {
            uis.scrollBackward();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }*/

        //选择借款天数
        UiObject2 magic_indicator = device.findObject(By.res(ShareLoan2_0.magic_indicator));
        Rect viewRect2 = magic_indicator.getVisibleBounds();
        int x2 = viewRect2.right;
        int y2 = viewRect2.bottom;
        for(int i = 0;i < 6;i++){
            device.click(x2/2,y2-10);
            //间隔一秒钟点击一次
             TestUse1026.sleep(2000);
             device.click(x2*3/4,y2-10);
             TestUse1026.sleep(2000);
        }

        //使用优惠券，点击一下
        UiObject2 discount_LL = device.findObject(By.res(ShareLoan2_0.discount_LL));
        discount_LL.click();

        TestUse1026.sleep(2000);
        //点击借款费用
        UiObject2 loan_repayMore_IV = device.findObject(By.res(ShareLoan2_0.loan_repayMore_IV));
        loan_repayMore_IV.click();

        //点击立即借款
        UiObject2 loan_Btn = device.findObject(By.res(ShareLoan2_0.loan_Btn));
        loan_Btn.click();

        //点击底部的loan_RecyclerView
/*        List<UiObject2> loan_RecyclerView = device.findObject(By.res(ShareLoan2_0.loan_RecyclerView));
        loan_RecyclerView.click();*/
    }

    //发现页面的点击事件
    public static void discover(){

    }

    //个人中心的点击事件
    public static void personal(){

    }
}
