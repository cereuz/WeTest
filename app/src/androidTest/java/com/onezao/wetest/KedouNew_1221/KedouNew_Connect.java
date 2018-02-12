package com.onezao.wetest.KedouNew_1221;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

import com.onezao.wetest.testutils.StringUtils;
import com.onezao.wetest.testutils.TestUse;

/**
 * Created by zneo on 2018/1/11.
 */

public class KedouNew_Connect {
    //判断是否登录，如果未登录，不做任何其他操作。如果已经登录，进入个人中心，将账户退出
    public static void quit(UiDevice device){
        TestUse.sleep(StringUtils.FIVESECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.tab_4).click();
        UiObject2 connect_close = TestUse.getUiObject2(device, KedouNew_Strings.close);
        if(connect_close == null){
            TestUse.getUiObject2(device,KedouNew_Strings.tab_2).click();
            TestUse.sleep(StringUtils.FIVESECOND);
            TestUse.getUiObject2(device,KedouNew_Strings.tab_3).click();
            TestUse.sleep(StringUtils.FIVESECOND);
            TestUse.getUiObject2(device,KedouNew_Strings.tab_4).click();
            TestUse.sleep(StringUtils.TWOSECOND);
            TestUse.getUiObject2(device,KedouNew_Strings.setting).click();
            TestUse.getUiObject2(device,KedouNew_Strings.logout).click();
        }
        TestUse.sleep(StringUtils.TWOSECOND);
        TestUse.getUiObject2(device, KedouNew_Strings.close).click();
    }
}
