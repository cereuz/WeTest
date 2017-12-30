package com.onezao.wetest.testwork;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.onezao.wetest.KedouNew_1221.KedouNew_main;
import com.onezao.wetest.ShareLoan2_0_1111.ShareLoan2_0_main;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

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
        //Loan2.0
//        ShareLoan2_0_main.testHere(device);

        //kedouNew
        KedouNew_main.kedouNew_main_start(device);
    }







}