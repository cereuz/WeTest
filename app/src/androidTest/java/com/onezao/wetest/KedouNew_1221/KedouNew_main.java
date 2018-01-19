package com.onezao.wetest.KedouNew_1221;

import android.support.test.uiautomator.UiDevice;

/**
 * Created by zneo on 2017/12/21.
 */

public class KedouNew_main {
    public static void kedouNew_main_start(UiDevice device){
/*        //启动APP
        KedouNew_unLogin.kedou_unLogin_start(device);
        //判断是否登录，如果已经登录，将帐户退出
        KedouNew_Connect.quit(device);*/
/*        //点击底部的四个tab栏
        KedouNew_unLogin.kedou_unLogin_tab(device);
        //顶部的title的控件操作
        KedouNew_unLogin.kedou_unLogin_title(device);
        //顶部的搜索功能
        KedouNew_unLogin.kedou_unlogin_search(device);
        //首页，title下边的操作。  整体操作
        KedouNew_unLogin.kedou_unLogin_front(device);
        //轮播图的操作
        KedouNew_unLogin.kedou_unLogin_Swiper(device);
        //几个列表的操作
        KedouNew_unLogin.kedou_unLogin_Lists(device);*/

        KedouNew_LoginAndRigister.kedou_login_register(device);

    }
}
