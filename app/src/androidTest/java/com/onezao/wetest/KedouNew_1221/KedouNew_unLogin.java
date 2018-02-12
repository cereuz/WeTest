package com.onezao.wetest.KedouNew_1221;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import com.onezao.wetest.testutils.StringUtils;
import com.onezao.wetest.testutils.TestUse;
import java.util.List;

import static android.support.test.InstrumentationRegistry.getContext;

/**
 * Created by zneo on 2017/12/21.
 */

public class KedouNew_unLogin {

    public static void kedou_unLogin_start(UiDevice device){
        //打开APP
        TestUse.openAPP(KedouNew_Strings.KEDOUPACAKAGE);
        TestUse.sleep(StringUtils.SIXSECOND);
        //点击引导页
        for(int i=0;i < 5;i++){
            TestUse.sleep(StringUtils.ONESECOND);
            TestUse.getUiObject2(device,KedouNew_Strings.viewpager).click();
            TestUse.sleep(StringUtils.ONESECOND);
            UiObject2 startBack = TestUse.getUiObject2(device,KedouNew_Strings.back);
            if(startBack != null){
                startBack.click();
            }
        }

    }

    //循环点击底部tab栏目
    public static void kedou_unLogin_tab(UiDevice device){
        //获取tab目录，并点击，循环几次
        for(int i=0 ;i < 3 ;i++) {
            TestUse.getUiObject2(device, KedouNew_Strings.tab_1).click();
            TestUse.getUiObject2(device, KedouNew_Strings.tab_3).click();
            TestUse.getUiObject2(device,KedouNew_Strings.close).click();
            TestUse.getUiObject2(device, KedouNew_Strings.tab_2).click();
            TestUse.getUiObject2(device,KedouNew_Strings.close).click();
            TestUse.getUiObject2(device, KedouNew_Strings.tab_4).click();
            TestUse.getUiObject2(device,KedouNew_Strings.close).click();
        }
    }

    //点击顶部
    public static void kedou_unLogin_title(UiDevice device){
        //获取Title  和  获取搜索框按钮
        TestUse.getUiObject2(device,KedouNew_Strings.title).click();
        TestUse.getUiObject2(device,KedouNew_Strings.rightImg).click();
        TestUse.getUiObject2(device,KedouNew_Strings.back).click();
    }

    //搜索框功能
    public static void kedou_unlogin_search(UiDevice device) {
        //搜索数组内 指定的ID用户
        for (int i = 0; i < KedouNew_Strings.kedouID_arr.length; i++) {
            //进入和退出搜索主播页面
            TestUse.getUiObject2(device, KedouNew_Strings.rightImg).click();
            TestUse.getUiObject2(device, KedouNew_Strings.back).click();
            TestUse.getUiObject2(device, KedouNew_Strings.rightImg).click();

            //不输入任何信息，直接点击搜索
            TestUse.getUiObject2(device, KedouNew_Strings.searchButton).click();
            //获取随机数，输入随机数，搜索主播
            int seed = KedouNew_Method.KedouNew_getRandom(StringUtils.SEED);
            TestUse.getUiObject2(device, KedouNew_Strings.search_editText).setText(String.valueOf(seed));
            TestUse.getUiObject2(device, KedouNew_Strings.searchButton).click();

            TestUse.getUiObject2(device, KedouNew_Strings.search_editText).setText(String.valueOf(KedouNew_Strings.kedouID_arr[i]));
            TestUse.sleep(StringUtils.ONESECOND);
            TestUse.getUiObject2(device, KedouNew_Strings.searchButton).click();
            TestUse.sleep(StringUtils.TWOSECOND);
            TestUse.getUiObject2(device, KedouNew_Strings.icon).click();

            dataPage(device);

            TestUse.getUiObject2(device, KedouNew_Strings.back).click();

/*         //进入用户详情页面，     页面跳转，需要预留缓冲时间。     //右上角的选择项，目前在未登录的时候是直接跳转到主页。没有预留返回空间
            TestUse.getUiObject2(device,KedouNew_Strings.rightImg).click();
            TestUse.sleep(StringUtils.TWOSECOND);
            //点击左上角的关闭按钮 ， 目前设置的是跳转到首页。
//          TestUse.getUiObject2(device,KedouNew_Strings.close).click();
            //点击系统的返回按键
            device.pressBack();*/
        }
    }

    private static void dataPage(UiDevice device) {
        //选中个人详情页面，上下滑动，查看信息     这个页面内容比较多，需要缓冲时间
        TestUse.sleep(StringUtils.THREESECOND);
        //第三个参数：speed	int: The speed at which to perform this gesture in pixels per second.
        TestUse.getUiObject2(device, KedouNew_Strings.scrollView).scroll(Direction.DOWN, 2f, 200);   //向上滑动;
        TestUse.getUiObject2(device, KedouNew_Strings.details_list_img).scroll(Direction.UP, 5f, 200);   //向下滑动;
        //点击个人资料页面  顶部的视频
        TestUse.getUiObject2(device, KedouNew_Strings.head).click();
        TestUse.sleep(StringUtils.TWENTYSECOND);
        UiObject2 search_start = TestUse.getUiObject2(device, KedouNew_Strings.start);
        if (search_start != null) {
            //预留一些时间，查看视频
            search_start.click();
            TestUse.sleep(StringUtils.TWENTYSECOND);
            device.pressBack();
        }

        //如果相册有图片，依次点击图片
        UiObject2 searchPhoto = TestUse.getUiObject2(device, KedouNew_Strings.photo);
        if (searchPhoto != null) {
            searchPhoto.click();
            TestUse.getUiObject2(device, KedouNew_Strings.rc_view_pager).scroll(Direction.LEFT, 6f, 200);
            TestUse.getUiObject2(device, KedouNew_Strings.rc_view_pager).scroll(Direction.RIGHT, 6f, 200);
            //如果有相册，就返回一次。返回个人资料页
            TestUse.getUiObject2(device, KedouNew_Strings.back).click();
        }
        //点击个人资料页的返回按钮，返回首页
        TestUse.getUiObject2(device, KedouNew_Strings.back).click();
    }

    //首页，title下边的操作。  整体操作
        public static void kedou_unLogin_front(UiDevice device) {
            //首页  向上滑动，向下滑动
            for (int i = 0; i < 3; i++) {
                TestUse.sleep(StringUtils.ONESECOND);
                TestUse.getUiObject2(device, KedouNew_Strings.recyclerview).scroll(Direction.DOWN, 3f, 200);
            }
            for (int i = 0; i < 3; i++) {
                TestUse.sleep(StringUtils.ONESECOND);
                TestUse.getUiObject2(device, KedouNew_Strings.recyclerview).scroll(Direction.UP, 3f, 200);
            }
            TestUse.sleep(StringUtils.ONESECOND);
            //依次点击  “推荐”“新人”“活跃”
            for(int i =0;i< 2;i++){
                TestUse.getUiObject2(device,KedouNew_Strings.recommend).click();
                TestUse.getUiObject2(device,KedouNew_Strings.active).click();
                TestUse.getUiObject2(device,KedouNew_Strings.new_person).click();
            }
        }

        //轮播图
    public static void kedou_unLogin_Swiper(UiDevice device){
        UiObject2 front_swiper = TestUse.getUiObject2(device, KedouNew_Strings.viewpager);
        if(front_swiper != null){
        //向左 向右依次滑动几次
        for(int i=0;i<3;i++) {
            TestUse.getUiObject2(device, KedouNew_Strings.viewpager).scroll(Direction.RIGHT, 3f, 200);
          }
        for(int i=0;i<3;i++) {
            TestUse.getUiObject2(device, KedouNew_Strings.viewpager).scroll(Direction.LEFT, 3f, 200);
          }
       //点击轮播图
            for(int i=0;i< 2;i++) {
                TestUse.getUiObject2(device, KedouNew_Strings.viewpager).click();
                TestUse.sleep(StringUtils.ONESECOND);
                TestUse.getUiObject2(device, KedouNew_Strings.content).scroll(Direction.DOWN, 3f, 200);
                TestUse.sleep(StringUtils.ONESECOND);
                TestUse.getUiObject2(device, KedouNew_Strings.back).click();
            }
      }
    }

    //操作  “推荐”“新人”“活跃”列表
    public static void kedou_unLogin_Lists(UiDevice device){
        TestUse.getUiObject2(device,KedouNew_Strings.recommend).click();
        recycleList(device);
        TestUse.getUiObject2(device,KedouNew_Strings.active).click();
        recycleList(device);
        TestUse.getUiObject2(device,KedouNew_Strings.new_person).click();
        recycleList(device);
    }

                //“推荐”“新人”“活跃”列表 的  刷新与进入页面点击操作。  局部页面的操作，被调用的方法
                private static void recycleList(UiDevice device) {
                    for (int i=0;i<3;i++) {
                        TestUse.getUiObject2(device, KedouNew_Strings.recyclerview).scroll(Direction.UP, 3f, 200);
                        TestUse.sleep(StringUtils.THREESECOND);
                        TestUse.getUiObject2(device, KedouNew_Strings.icon).click();
                        dataPage(device);
                    }
                }
}
