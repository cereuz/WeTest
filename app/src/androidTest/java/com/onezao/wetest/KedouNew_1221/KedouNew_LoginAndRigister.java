package com.onezao.wetest.KedouNew_1221;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

import com.onezao.wetest.testutils.StringUtils;
import com.onezao.wetest.testutils.TestUse;

/**
 * Created by zneo on 2018/1/11.
 */

public class KedouNew_LoginAndRigister {
    //  登录注册   功能
    public static void kedou_login_register(UiDevice device){
/*        //进入登录注册页面
        UiObject2 LRclose = TestUse.getUiObject2(device,KedouNew_Strings.close);
        if(LRclose != null){
            LRclose.click();
        }*/
/*        TestUse.getUiObject2(device,KedouNew_Strings.tab_2).click();*/
/*        TestUse.getUiObject2(device,KedouNew_Strings.close).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.tab_3).click();
        TestUse.sleep(StringUtils.TWOSECOND);*/
        TestUse.getUiObject2(device,KedouNew_Strings.et_phone).setText(KedouNew_Method.KedouNew_getPhone());
        TestUse.sleep(StringUtils.SIXSECOND);

    }
}
