package com.onezao.wetest.TestForStudy;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

import com.onezao.wetest.ShareLoan2_0_1111.TestUse1026;

/**
 * 具体的操作代码
 */

public class TestWork1026 {
    public static void send1026(UiDevice device) {
         /*       //点击关注，取消关注
            UiObject2 followRed = device.findObject(By.res("com.gcs.mcj.chat:id/connect"));
            followRed.click();
            sleep(2000);*/
        //  返回主页
//            device.pressHome();

    /*         // 单击返回键
            for(int x= 0;x < 6 ;x++){
                device.pressBack();
                sleep(2000);
            }*/


/*           //进入黑名单，添加黑名单
            UiObject2 blackList = device.findObject(By.res("com.gcs.mcj.chat:id/img_right"));
            blackList.click();
            sleep(2000);
            UiObject2 addToBlackList = device.findObject(By.res("com.gcs.mcj.chat:id/blackTextView"));
            addToBlackList.click();*/

        //进入手机短信编辑页面，输入短信，清除短信，重新输入短信
        //UiObject2 sendMessage = device.findObject(By.res("com.android.mms:id/embedded_text_editor"));

        for (int x = 0; x < 10; x++) {
//            UiObject2 sendMessage = device.findObject(By.res("com.gcs.mcj.chat:id/rc_edit_text"));
            UiObject2 sendMessage = device.findObject(By.res("com.tencent.mobileqq:id/input"));
            //  UiObject2 sendMessage = device.findObject(By.res("com.tencent.mobileqq:id/name"));
//            UiObject2 sendMessage = device.findObject(By.res("com.tencent.mm:id/bwm"));
            sendMessage.clear();
            sendMessage.setText(x + ". 今天星期一，心情不错！ \n" + TestUse1026.getSystemTime());
            TestUse1026.sleep(2000);
            UiObject2 sendMessage2 = device.findObject(By.text("发送"));
            sendMessage2.click();
            TestUse1026.sleep(2000);
            sendMessage.clear();
            TestUse1026.sleep(2000);
            sendMessage.setText(x + ". Good good study，day day up.  \n" + TestUse1026.getSystemTime());
            sendMessage2.click();

//            sendMessage.scroll(Direction.DOWN,0.75f,3000);
        }
    }

    public static void findTitle(UiDevice device){
//       UiObject2 Ftitle = device.findObject(By.text("TT"));

        UiObject2  Ftitle =  device.findObject(By.res("com.tencent.mobileqq:id/relativeItem"));
        if(Ftitle != null){
            Ftitle.click();
        }
    }

    //找到listView的某一个item
    public static void findListViewItem(UiDevice device){
//        UiObject2  noteList = device.findObject(By.textContains("喵喵"));
        UiObject2  noteList = device.findObject(By.res("com.tencent.mobileqq:id/title"));
        if(noteList != null){
            noteList.click();
        }
    }
}
