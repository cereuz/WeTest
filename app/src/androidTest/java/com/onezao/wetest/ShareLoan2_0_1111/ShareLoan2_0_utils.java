package com.onezao.wetest.ShareLoan2_0_1111;

import android.graphics.Rect;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import java.util.List;

/**
 * Created by zneo on 2017/11/24.
 */

public class ShareLoan2_0_utils {
    //间隔时间的确定
    public static int oneSecond = 1000;
    public static int theSecond = 2000;
    public static int THREESECOND = 3000;
    public static int longSecond = 6000;
    //定义可以滑动的对象
    public static UiScrollable uis ;
    //新手福利的  WebView
    public static String  newBonusWebView = "android.webkit.WebView";
    //WebView的父控件
    public static String  agentView_ParentView = "com.gcs.wang.loan:id/agentView_ParentView";

    //未登录状态，点击新手福利
    public static void loan_RecyclerViewMethod(UiDevice device){
        List<UiObject2> list_item_IV = device.findObjects(By.res(ShareLoan2_0.item_IV));
        for (int i=0;i< list_item_IV.size();i++) {
            //间隔几秒钟
            TestUse1026.sleep(theSecond);
            list_item_IV.get(i).click();
            if(i==0) {
                TestUse1026.sleep(theSecond);
                uis = new UiScrollable(new UiSelector().scrollable(true));
                //滑动  WebView
                // 第三个参数：speed	int: The speed at which to perform this gesture in pixels per second.
                TestUse1026.getUiObject2(device,agentView_ParentView).scroll(Direction.DOWN, 2f,200);
                TestUse1026.sleep(theSecond);
                //获取WebView的底部按钮位置
                Rect newBonusRect = device.findObject(By.clazz(newBonusWebView)).getVisibleBounds();
                int x = newBonusRect.right;
                int y = newBonusRect.bottom;
                    device.click(x/2,y-20);
                    //间隔几秒钟
                    TestUse1026.sleep(longSecond);
                  //退出登录界面
                 ShareLoan2_0.login_out(device);
                //间隔几秒钟
                TestUse1026.sleep(theSecond);
                //退出新手福利页面
                TestUse1026.getUiObject2(device,ShareLoan2_0.rlyt_left).click();
            } else if (i==1) {
                //间隔几秒钟
                TestUse1026.sleep(theSecond);
                //退出登录界面
                ShareLoan2_0.login_out(device);
              }  else if(i==2){
                break;
            }
            //间隔2秒钟
            TestUse1026.sleep(5000);
        }
    }
}
