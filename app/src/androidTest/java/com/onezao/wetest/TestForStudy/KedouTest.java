package com.onezao.wetest.TestForStudy;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

import com.onezao.wetest.ShareLoan2_0_1111.TestUse1026;

/**
 * Created by zneo on 2017/11/13.
 */

public class KedouTest {
       public static String head = "com.gcs.mcj.chat:id/head";
       public static String icon_back = "com.gcs.mcj.chat:id/icon_back";
       public static  void  Kedou100(UiDevice device){
      for (int x = 0; x < 10000; x++) {
//  UiObject2 sendMessage = device.findObject(By.res("com.gcs.mcj.chat:id/rc_edit_text"));
          TestUse1026.sleep(2000);
          UiObject2 KClick = device.findObject(By.res(head));
          KClick.click();
          TestUse1026.sleep(2000);
          UiObject2 KClick2 = device.findObject(By.res(icon_back));
          KClick2.click();
          TestUse1026.sleep(2000);
      }
    }
}
