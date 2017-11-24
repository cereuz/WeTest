package com.onezao.wetest.testwork;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.onezao.wetest.testutils.KedouTest;
import com.onezao.wetest.testutils.ShareLoan2_0;
import com.onezao.wetest.testutils.TestUse1026;
import com.onezao.wetest.testutils.TestWork1026;
import com.squareup.spoon.Spoon;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;

/**
 * Created by zneo on 2017/10/24.
 */

@RunWith(AndroidJUnit4.class)
public class uiauto {
    UiDevice device;
    Instrumentation instrumentation;
    Context context;
    @Before
    public void setUp(){
        instrumentation = getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
          }

    @Test
    public void test(){
        //调用测试共享现金的方法
        testLoan2_0();
       /* //打开蝌蚪APP
        TestUse1026.openAPP(context,"com.gcs.mcj.chat");*/
    }

      //测试共享现金2.0
    public void testLoan2_0(){
        //从启动页到借款页面，需要一点缓冲时间。不然会空指针异常。页面切换之间都需要给出缓冲时间。
        //打开共享现金APP
        TestUse1026.openAPP(TestUse1026.PACKAGENAMEZAO);
 /*     TestUse1026.sleep(3000);
        //启动页，只在第一次安装的时候才调用这个方法
        ShareLoan2_0.slogan(device);*/

/*     TestUse1026.sleep(3000);
      //首页的操作
        ShareLoan2_0.prepare(device);*/
/*   //点击进入借款页面
        ShareLoan2_0.borrow(device);
        TestUse1026.sleep(3000);*/
/*      TestUse1026.sleep(3000);
       //点击进入发现页面
        ShareLoan2_0.discover(device);*/
        TestUse1026.sleep(6000);
//        String path1 = context.getFilesDir().getPath()+"cool.png";
        TestUse1026.snapPic(device,TestUse1026.PACKAGENAMEZAO);
        //点击进入个人中心
//        ShareLoan2_0.personal(device);
    }
}