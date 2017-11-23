package com.onezao.wetest.testutils;

import android.content.Context;
import android.graphics.Rect;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
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
    //【零、共享现金2.0】包名
    public static String packageName = "com.gcs.wang.loan";
    //定义可以滑动的对象
    public static UiScrollable uis ;

    //【一、启动页】启动页的“我要借款”按钮
    public static String button_slogan_id = "com.gcs.wang.loan:id/tv";

    //【二、首页】首页底部的“借款”
    public static String btn_0 = "com.gcs.wang.loan:id/btn_0";
    public static String loan_TV = "com.gcs.wang.loan:id/loan_TV";
    //首页底部的“发现”
    public static String btn_1 = "com.gcs.wang.loan:id/btn_1";
    //首页底部的“个人中心”
    public static String btn_2 = "com.gcs.wang.loan:id/btn_2";
    public static String my_IV = "com.gcs.wang.loan:id/my_IV";


    //【三、借款页面】借款页面的“可借金额”滑动选择框
    public static String money_can_borrow = "com.gcs.wang.loan:id/loan_stringScrollPicker";
    //可借日期的选择
    public static String magic_indicator = "com.gcs.wang.loan:id/magic_indicator";
    //使用优惠券，点击查看优惠券，然后选择使用优惠券
    public static String discount_LL = "com.gcs.wang.loan:id/discount_LL";
    //点击借款费用的问号
    public static String loan_repayMore_IV = "com.gcs.wang.loan:id/loan_repayMore_IV";
    //点击立即借款
    public static String loan_Btn = "com.gcs.wang.loan:id/loan_Btn";
    //点击底部的重复使用View  ，  【发现页面】的item_IV  使用的是同样的ID
    public static String item_IV = "com.gcs.wang.loan:id/item_IV";
    //登录界面的左上角返回按钮
    public static String rlyt_left = "com.gcs.wang.loan:id/rlyt_left";
    //登录界面的“下一步”按钮
    public static String btn_normal = "com.gcs.wang.loan:id/btn_normal";


    //【四、发现】页面
    //【五、个人中心】



    //----------------------【一、启动页】启动页，只在第一次安装的时候才调用这个方法---------------
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


    //-----------------------【二、首页】首页整体页面的操作---------------------------
    public static void prepare(UiDevice device){
        for (int i=0;i< 6;i++) {
            //点击借款
            TestUse1026.getUiObject2(device, loan_TV).click();
            //间隔一秒钟点击一次
            TestUse1026.sleep(1000);
            //点击个人中心
            TestUse1026.getUiObject2(device, my_IV).click();
            //间隔一秒钟点击一次
            TestUse1026.sleep(1000);
            //点击发现
            TestUse1026.getUiObject2(device, btn_1).click();
            //间隔一秒钟点击一次
            TestUse1026.sleep(1000);
        }
    }

    //------------------------【三、借款页面】借款页面的点击事件-----------------------------------
    public static void  borrow(UiDevice device){
        //点击借款，进入借款页面
        TestUse1026.getUiObject2(device, loan_TV).click();
        //间隔一秒钟点击一次
        TestUse1026.sleep(3000);

        //顶部的可借金额，动画效果，未能监听。     不能点击，不能滑动。通过device左边来点击
        UiObject2 money_can_borrow = device.findObject(By.res(ShareLoan2_0.money_can_borrow));
        //直接滑动屏幕，来切换借款额度
        //第三个参数：speed	int: The speed at which to perform this gesture in pixels per second.
        money_can_borrow.scroll(Direction.LEFT, 20f,200);
        TestUse1026.sleep(2000);
        //获取屏幕位置，同一个位置多次点击
        Rect viewRect = money_can_borrow.getVisibleBounds();
        int x = viewRect.right;
        int y = viewRect.bottom;
        for(int i = 0;i < 10;i++){
            device.click(x/2-x/5,y-20);
            //间隔一秒钟点击一次
            TestUse1026.sleep(1000);
        }


        //这个是在选择框内滑动，选择框是固定的，只是手势滑动屏幕  ，  这个点击事件暂时没有实现。
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
             TestUse1026.sleep(1000);
             device.click(x2*3/4,y2-10);
             TestUse1026.sleep(1000);
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

        //未登录情况下，点击立即借款，进入登录界面
        //间隔2秒钟
        TestUse1026.sleep(2000);
        //不输入信息，直接点击下一步
        UiObject2 btn_normal = device.findObject(By.res(ShareLoan2_0.btn_normal));
        btn_normal.click();

        //间隔2秒钟
        TestUse1026.sleep(2000);

        //点击左上角的返回按钮
        UiObject2 rlyt_left = device.findObject(By.res(ShareLoan2_0.rlyt_left));
        rlyt_left.click();

        //间隔2秒钟
        TestUse1026.sleep(2000);
        //点击底部的loan_RecyclerView
        List<UiObject2> list_item_IV = device.findObjects(By.res(ShareLoan2_0.item_IV));
        for (UiObject2 item_IV:list_item_IV) {
            item_IV.click();
            //间隔2秒钟
            TestUse1026.sleep(5000);
        }

    }

    //-----------------------【四、发现】发现页面的点击事件-----------------------------------------
    public static void discover(UiDevice device){
        //点击发现
        TestUse1026.getUiObject2(device, btn_1).click();
        //间隔一秒钟点击一次
        TestUse1026.sleep(1000);

        for(int i=0;i<6;i++){
        //点击发现页面的各个模块
       List<UiObject2> uiOb2s =  TestUse1026.getUiObject2s(device,item_IV);
        for(UiObject2 uiOb2 : uiOb2s){
             uiOb2.click();
            //间隔一秒钟点击一次
            TestUse1026.sleep(3000);
        }
      }
    }

    //---------------------【五、个人中心】个人中心的点击事件--------------------------------------
    public static void personal(UiDevice device){
        //点击个人中心
        TestUse1026.getUiObject2(device, my_IV).click();
        //间隔一秒钟点击一次
        TestUse1026.sleep(1000);
    }
}
