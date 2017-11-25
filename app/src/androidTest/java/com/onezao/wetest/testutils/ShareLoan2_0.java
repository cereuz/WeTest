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
    //登录界面的左上角返回按钮；身份证识别，返回按钮
    public static String rlyt_left = "com.gcs.wang.loan:id/rlyt_left";
    //登录界面的“下一步”按钮
    public static String btn_normal = "com.gcs.wang.loan:id/btn_normal";



    //【四、发现】页面
    //【五、个人中心】
    public static String ScrollView = "android.widget.ScrollView";
    public static String title_RelativeLayout = "com.gcs.wang.loan:id/title_RelativeLayout";
    public static String personalSwipeRefreshLayout = "com.gcs.wang.loan:id/personalSwipeRefreshLayout";
    //个人中心的头像
    public static String head_IV = "com.gcs.wang.loan:id/head_IV";
    //个人中心的昵称
    public static String nickName_TV = "com.gcs.wang.loan:id/nickName_TV";
    //个人中心右上角的消息图片
    public static String message_RL = "com.gcs.wang.loan:id/message_RL";
    //当前应还金额
    public static String repay_Money_TV = "com.gcs.wang.loan:id/repay_Money_TV";
    //当前应还日期
    public static String repay_Date_TV = "com.gcs.wang.loan:id/repay_Date_TV";
    //身份证识别页面，识别框
    public static String bg_ImageView = "com.gcs.wang.loan:id/bg_ImageView";
    public static String facedetect_sfv_preview = "com.gcs.wang.loan:id/facedetect_sfv_preview";
    //还款倒计时
    public static String repaymentData_FTV = "com.gcs.wang.loan:id/repaymentData_FTV";
    //已绑定银行卡
    public static String bankIsBind_TV = "com.gcs.wang.loan:id/bankIsBind_TV";
    //主动还款
    public static String repayMoney_TV = "com.gcs.wang.loan:id/repayMoney_TV";
    //我要续期
    public static String continueMoney_TV = "com.gcs.wang.loan:id/continueMoney_TV";
    //认证资料
    public static String ll_identitydata = "com.gcs.wang.loan:id/ll_identitydata";
    //银行卡
    public static String ll_bankcard = "com.gcs.wang.loan:id/ll_bankcard";
    //借款记录
    public static String ll_loan_record = "com.gcs.wang.loan:id/ll_loan_record";
    //自动续期
    public static String ll_autoxuqi = "com.gcs.wang.loan:id/ll_autoxuqi";
    //邀请有礼
    public static String ll_invite = "com.gcs.wang.loan:id/ll_invite";
    //优惠券
    public static String ll_yhjuan = "com.gcs.wang.loan:id/ll_yhjuan";
    //我的钱包
    public static String ll_mypurse = "com.gcs.wang.loan:id/ll_mypurse";
    //帮助中心
    public static String ll_helpcenter = "com.gcs.wang.loan:id/ll_helpcenter";
    //个人设置
    public static String ll_safemanager = "com.gcs.wang.loan:id/ll_safemanager";
    //客服热线
    public static String ll_kefurexian = "com.gcs.wang.loan:id/ll_kefurexian";
    //拨打客服电话
    public static String btn_pos = "com.gcs.wang.loan:id/btn_pos";




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
            if(slogan_btn != null){
                slogan_btn.click();
            }
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
            TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
            //点击个人中心
            TestUse1026.getUiObject2(device, my_IV).click();
            //间隔一秒钟点击一次
            TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
            //点击发现
            TestUse1026.getUiObject2(device, btn_1).click();
            //间隔一秒钟点击一次
            TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
        }
    }

    //------------------------【三、借款页面】借款页面的点击事件-----------------------------------
    public static void  borrow(UiDevice device){
        //点击借款，进入借款页面
        TestUse1026.getUiObject2(device, loan_TV).click();
        //间隔一秒钟点击一次
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);

        //顶部的可借金额，动画效果，未能监听。     不能点击，不能滑动。通过device左边来点击
        UiObject2 money_can_borrow = device.findObject(By.res(ShareLoan2_0.money_can_borrow));
        //直接滑动屏幕，来切换借款额度
        //第三个参数：speed	int: The speed at which to perform this gesture in pixels per second.
        money_can_borrow.scroll(Direction.LEFT, 6f,200);
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        //获取屏幕位置，同一个位置多次点击
        Rect viewRect = money_can_borrow.getVisibleBounds();
        int x = viewRect.right;
        int y = viewRect.bottom;
        for(int i = 0;i < 6;i++){
            device.click(x/2-x/5,y-20);
            //间隔一秒钟点击一次
            TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
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
             TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
             device.click(x2*3/4,y2-10);
             TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
        }

        //使用优惠券，点击一下
        UiObject2 discount_LL = device.findObject(By.res(ShareLoan2_0.discount_LL));
        discount_LL.click();

        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //点击借款费用
        UiObject2 loan_repayMore_IV = device.findObject(By.res(ShareLoan2_0.loan_repayMore_IV));
        loan_repayMore_IV.click();

        //点击立即借款
        UiObject2 loan_Btn = device.findObject(By.res(ShareLoan2_0.loan_Btn));
        loan_Btn.click();

        //未登录情况下，点击立即借款，进入登录界面，然后返回
        login_out(device);


        //间隔2秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        //点击底部的loan_RecyclerView
        ShareLoan2_0_utils.loan_RecyclerViewMethod(device);


    }

    //【登录界面的返回操作】未登录情况下，点击立即借款，进入登录界面，然后返回
    public static void login_out(UiDevice device) {
        //间隔2秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        //不输入信息，直接点击下一步
        UiObject2 btn_normal = device.findObject(By.res(ShareLoan2_0.btn_normal));
        btn_normal.click();

        //间隔2秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);

        //点击左上角的返回按钮
        UiObject2 rlyt_left = device.findObject(By.res(ShareLoan2_0.rlyt_left));
        rlyt_left.click();
    }

    //-----------------------【四、发现】发现页面的点击事件-----------------------------------------
    public static void discover(UiDevice device) {
        //点击发现
        TestUse1026.getUiObject2(device, btn_1).click();
        //间隔一秒钟点击一次
        TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);

            //点击发现页面的各个模块  !!!!!!!!!!!!!
            List<UiObject2> uiOb2s = TestUse1026.getUiObject2s(device, item_IV);
            for (int m=0;m< uiOb2s.size(); m++) {
                //间隔几秒钟
                TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
                uiOb2s.get(m).click();
                //间隔几秒钟
                TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
                //判断一下是否有返回按钮
                if(TestUse1026.getUiObject2(device, ShareLoan2_0.rlyt_left) != null){
                    TestUse1026.getUiObject2(device, ShareLoan2_0.rlyt_left).click();
                }
                }
            }


    //---------------------【五、个人中心】个人中心的点击事件--------------------------------------
    public static void personal(UiDevice device){
        //点击个人中心
        TestUse1026.getUiObject2(device, my_IV).click();
        //间隔一秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);

        //个人中心上下滑动，查看页面整体内容。
        UiObject2 ScrollView = device.findObject(By.res(ShareLoan2_0.personalSwipeRefreshLayout));
        //直接滑动屏幕，来切换借款额度
        //第三个参数：speed	int: The speed at which to perform this gesture in pixels per second.
        ScrollView.scroll(Direction.DOWN, 2f,200);   //向上滑动
        UiObject2 ScrollView2 = device.findObject(By.res(ShareLoan2_0.ll_mypurse));
        ScrollView2.scroll(Direction.UP, 15f,20000);    //向下滑动

        //点击个人中心的头像
        TestUse1026.getUiObject2(device,head_IV).click();
        TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
        //进入登录界面，然后返回。
        login_out(device);
        //间隔一秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
        //点击昵称位置
        TestUse1026.getUiObject2(device,nickName_TV).click();
        //进入登录界面，然后返回。
        login_out(device);
        //间隔一秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.oneSecond);
        //点击右上角的消息按钮
        TestUse1026.getUiObject2(device,message_RL).click();
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //点击当前应还金额
        TestUse1026.getUiObject2(device,repay_Money_TV).click();
        //允许读取摄像头。
        TestUse1026.btnAllow(device);
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //点击身份证识别框
        TestUse1026.getUiObject2(device,facedetect_sfv_preview).click();
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //点击身份证识别框的返回按钮
        TestUse1026.getUiObject2(device,rlyt_left).click();
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //点击当前应还日期
        TestUse1026.getUiObject2(device,repay_Date_TV).click();
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //点击身份证识别框第二个  ，有时候没有摄像头，做一下非空判断
        if(TestUse1026.getUiObject2(device,bg_ImageView) != null){
            TestUse1026.getUiObject2(device,bg_ImageView).click();
            //间隔几秒钟
            TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
            //点击身份证识别框的返回按钮
            TestUse1026.getUiObject2(device,rlyt_left).click();
        }
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        //点击还款倒计时
       TestUse1026.getUiObject2(device,repaymentData_FTV).click();
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //已绑定银行卡
        TestUse1026.getUiObject2(device,bankIsBind_TV).click();
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //主动还款
        TestUse1026.getUiObject2(device,repayMoney_TV).click();
        //间隔几秒钟
        TestUse1026.sleep(ShareLoan2_0_utils.longSecond);
        //我要续期
        TestUse1026.getUiObject2(device,continueMoney_TV).click();

        //向上滑动，显示下边的信息
        ScrollView.scroll(Direction.DOWN, 2f,200);   //向上滑动


        //认证资料
        TestUse1026.getUiObject2(device,ll_identitydata).click();
        //银行卡
        TestUse1026.getUiObject2(device,ll_bankcard).click();
        //借款记录
        TestUse1026.getUiObject2(device,ll_loan_record).click();
        //自动续期
        TestUse1026.getUiObject2(device,ll_autoxuqi).click();
        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        login_out(device);
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        //邀请有礼
        TestUse1026.getUiObject2(device,ll_invite).click();
        //优惠券
        TestUse1026.getUiObject2(device,ll_yhjuan).click();
        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        login_out(device);
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        //我的钱包
        TestUse1026.getUiObject2(device,ll_mypurse).click();
        //帮助中心
        TestUse1026.getUiObject2(device,ll_helpcenter).click();
        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        login_out(device);
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        //个人设置
        TestUse1026.getUiObject2(device,ll_safemanager).click();
        TestUse1026.sleep(ShareLoan2_0_utils.THREESECOND);
        login_out(device);
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        //客服热线
        TestUse1026.getUiObject2(device,ll_kefurexian).click();
        TestUse1026.sleep(ShareLoan2_0_utils.theSecond);
        TestUse1026.getUiObject2(device,btn_pos).click();

    }
}
