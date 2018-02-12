package com.onezao.wetest.KedouNew_1221;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;

import com.onezao.wetest.testutils.StringUtils;
import com.onezao.wetest.testutils.TestUse;

import java.util.List;
import java.util.Random;

/**
 * Created by zneo on 2018/1/11.
 */

public class KedouNew_LoginAndRigister {
    //  登录注册   功能
    //手机号的登录注册
    public static void kedou_login_register_phone(UiDevice device){
        //进入登录注册页面
        UiObject2 LRclose = TestUse.getUiObject2(device,KedouNew_Strings.close);
        if(LRclose != null){
            LRclose.click();
        }
        //点击底部的tab栏
        TestUse.getUiObject2(device,KedouNew_Strings.tab_2).click();
        TestUse.getUiObject2(device,KedouNew_Strings.close).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.tab_3).click();
        TestUse.sleep(StringUtils.TWOSECOND);

        //随机输入数字
        for(int m=0;m<3;m++) {
            //设置电话号码
            TestUse.getUiObject2(device, KedouNew_Strings.et_phone).setText("1");
            for (int i = 1; i < 11; i++) {
                TestUse.getUiObject2(device, KedouNew_Strings.et_phone).setText(KedouNew_Method.KedouNew_getVeriCode(i));
            }
            TestUse.sleep(StringUtils.TWOSECOND);
            for (int i = 1; i < 4; i++) {
                TestUse.getUiObject2(device, KedouNew_Strings.et_code).setText(KedouNew_Method.KedouNew_getVeriCode(i));
            }
            TestUse.getUiObject2(device,KedouNew_Strings.image_code).click();
        }

        //从正确的号码库选择之后，正常登录
        for(int m=0;m<3;m++){
             int randomPhone =  new Random().nextInt(KedouNew_Strings.kedouPhone_arr.length);
             TestUse.getUiObject2(device,KedouNew_Strings.et_phone).click();
             TestUse.getUiObject2(device,KedouNew_Strings.et_phone).setText(KedouNew_Strings.kedouPhone_arr[randomPhone]);
             TestUse.getUiObject2(device,KedouNew_Strings.image_code).click();
             TestUse.getUiObject2(device,KedouNew_Strings.et_phone).click();
             TestUse.getUiObject2(device, KedouNew_Strings.et_code).setText(KedouNew_Method.KedouNew_getVeriCode(3));
             TestUse.sleep(StringUtils.TWOSECOND);
             TestUse.getUiObject2(device, KedouNew_Strings.et_code).setText(KedouNew_Method.KedouNew_getVeriCode(5));
             TestUse.getUiObject2(device,KedouNew_Strings.send_code).click();
             TestUse.sleep(StringUtils.TWOSECOND);
             TestUse.getUiObject2(device,KedouNew_Strings.send_code).click();
             TestUse.sleep(StringUtils.TWOSECOND);
             TestUse.getUiObject2(device,KedouNew_Strings.bt_login).click();
             KedouNew_Connect.quit(device);
             TestUse.getUiObject2(device,KedouNew_Strings.tab_4).click();
        }
             TestUse.getUiObject2(device,KedouNew_Strings.close).click();
    }

    // QQ 注册登录
    public static void kedou_login_register_QQ(UiDevice device){
        TestUse.sleep(StringUtils.TWOSECOND);
        KedouNew_Connect.quit(device);
        //点击底部的tab栏
        TestUse.getUiObject2(device,KedouNew_Strings.tab_2).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.close).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.tab_3).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        //点击QQ登录按钮
        TestUse.getUiObject2(device,KedouNew_Strings.iv_login_qq).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        clickQQImageView(device);

        //查看QQ号是否已经登录。
        UiObject2  qq = device.findObject(By.text("3390693042"));
        if(qq != null){
            device.findObject(By.text("3390693042")).click();
            device.findObject(By.text("登录")).click();
            //如果没有绑定，即没有输入手机号码框，就需要进行绑定号码操作
            TestUse.sleep(StringUtils.TWOSECOND);
            UiObject2  et_phone = TestUse.getUiObject2(device,KedouNew_Strings.et_phone);
            if(et_phone != null){
            bindVeriPhone(device,KedouNew_Strings.QQ_PhoneNumber);
            }

/*            //针对已经存在的QQ，删除三次
            for (int i=0;i<3;i++){
                deleteQQ(device);
            }*/
/*          //逻辑较多，暂时处理不了。不删除了。
            //如果存在这个QQ，就在登录之后把所有的QQ都删除
            KedouNew_Connect.quit(device);
            TestUse.getUiObject2(device,KedouNew_Strings.tab_4).click();
            TestUse.getUiObject2(device,KedouNew_Strings.iv_login_qq).click();
            deleteQQ(device);*/
        }  else {
            device.findObject(By.text("添加帐号")).click();
            TestUse.getUiObject2(device,KedouNew_Strings.account_qq).setText("3390693042");
            TestUse.getUiObject2(device,KedouNew_Strings.password_qq).setText("wz333666");
            device.findObject(By.text("登录")).click();
            //如果没有绑定，即没有输入手机号码框，就需要进行绑定号码操作
            TestUse.sleep(StringUtils.THREESECOND);
            UiObject2  et_phone = TestUse.getUiObject2(device,KedouNew_Strings.et_phone);
            if(et_phone != null){
                bindVeriPhone(device,KedouNew_Strings.QQ_PhoneNumber);
            }
        }
    }

    //微信注册，登录
    public static void kedou_login_register_weixin(UiDevice device){
        KedouNew_Connect.quit(device);
        //点击底部的tab栏
        TestUse.getUiObject2(device,KedouNew_Strings.tab_2).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.close).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.tab_3).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        //点击微信登录按钮
        TestUse.getUiObject2(device,KedouNew_Strings.iv_login_wx).click();
        TestUse.sleep(StringUtils.TWOSECOND);
        UiObject2 weixin_login = TestUse.getUiObject2(device,KedouNew_Strings.weixin_account_password);
        List<UiObject2> weixinList = TestUse.getUiObject2s(device,KedouNew_Strings.weixin_account_password);
        if(weixin_login != null) {
            for (int i = 0; i < weixinList.size(); i++) {
                if (i == 0) {
                    weixinList.get(i).click();
                    weixinList.get(i).setText("zenote");
                } else if (i == 1) {
                    weixinList.get(i).click();
                    weixinList.get(i).setText("wz333666");
                }
            }
            TestUse.sleep(StringUtils.TWOSECOND);
            TestUse.getUiObject2(device, KedouNew_Strings.btn_weixin_login).click();
        }
        TestUse.sleep(StringUtils.FIVESECOND);
       //判断是否有立即登录按钮，如果有，就点击登录
       UiObject2 btn_weixin_login = TestUse.getUiObject2(device,KedouNew_Strings.btn_weixin_login);
        if(btn_weixin_login != null){
            btn_weixin_login.click();
        }
        TestUse.sleep(StringUtils.FIVESECOND);
        //判断是否有绑定手机号码输入框，如果有，就进行绑定号码操作
        UiObject2 et_phone = TestUse.getUiObject2(device, KedouNew_Strings.et_phone);
        if(et_phone != null) {
            bindVeriPhone(device, KedouNew_Strings.weixin_PhoneNumber);
        }
    }


    private static void deleteQQ(UiDevice device) {
        TestUse.sleep(StringUtils.TWOSECOND);
        KedouNew_Connect.quit(device);
        TestUse.getUiObject2(device,KedouNew_Strings.tab_4).click();
        TestUse.getUiObject2(device,KedouNew_Strings.iv_login_qq).click();
        TestUse.sleep(StringUtils.FIVESECOND);
        //判断一下，如果是QQ登录界面，就进行点击，进行删除QQ操作，如果不是，就不做任何操作。
        UiObject2  textUO2_qq = TestUse.getUiObject2Text(device,"QQ登录");
        if(textUO2_qq != null) {
            clickQQImageView(device);
            TestUse.sleep(StringUtils.TWOSECOND);
            //循环点击ImageView
            List<UiObject2> UiOb2s_QQ_ImageViewIn = device.findObjects(By.clazz("android.widget.ImageView"));
            //如果ImageView大于三个,即最少有四个。就删除最后一个
            while (UiOb2s_QQ_ImageViewIn.size() > 4) {
                for (int i = 0; i < UiOb2s_QQ_ImageViewIn.size(); i++) {
                    //只点击最后一个ImageView
                    while (i == 4) {
                        UiOb2s_QQ_ImageViewIn.get(i).click();
                        TestUse.sleep(StringUtils.ONESECOND);
                        TestUse.getUiObject2(device, KedouNew_Strings.dialogRightBtn).click();
                        TestUse.sleep(StringUtils.FIVESECOND);
                        UiObject2 textReturn = TestUse.getUiObject2Text(device,"返回");
                        if(textReturn != null){
                            textReturn.click();
                            TestUse.getUiObject2(device,KedouNew_Strings.close).click();
                        }
                    }
                }
            }
        }
    }

    //QQ注册登录界面的ImageView循环点击
    private static void clickQQImageView(UiDevice device) {
        TestUse.sleep(StringUtils.TWOSECOND);
        //循环点击ImageView ,  图标，底部的更多按钮
        List<UiObject2> UiOb2s_QQ_ImageVIew =  device.findObjects(By.clazz("android.widget.ImageView"));
        for (UiObject2  uqiv: UiOb2s_QQ_ImageVIew){
                uqiv.click();
        }
        TestUse.sleep(StringUtils.ONESECOND);
        TestUse.getUiObject2Class(device,"android.widget.ImageView").scroll(Direction.DOWN, 3f, 200);
    }

    //绑定号码逻辑
    private static void bindVeriPhone(UiDevice device,String phoneNum) {
        TestUse.sleep(StringUtils.SIXSECOND);
        TestUse.getUiObject2(device, KedouNew_Strings.et_phone).setText(phoneNum);
        TestUse.getUiObject2(device,KedouNew_Strings.et_code).setText(KedouNew_Method.KedouNew_getVeriCode(3));
        TestUse.sleep(StringUtils.ONESECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.bt_login).click();
        TestUse.getUiObject2(device,KedouNew_Strings.et_code).setText(KedouNew_Method.KedouNew_getVeriCode(5));
        TestUse.sleep(StringUtils.ONESECOND);
        TestUse.getUiObject2(device,KedouNew_Strings.bt_login).click();
    }
}
