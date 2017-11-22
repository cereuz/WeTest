package com.onezao.wetest.testwork;

import android.app.Instrumentation;
import android.content.Context;
import android.os.Build;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.onezao.wetest.testutils.KedouTest;
import com.onezao.wetest.testutils.TestUse1026;
import com.onezao.wetest.testutils.TestWork1026;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

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

    @Before
    public void grantPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getInstrumentation().getUiAutomation().executeShellCommand(
                    "pm grant " + getTargetContext().getPackageName()
                            + " android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }
    @Test
    public void test(){
        TestUse1026.openAPP(context,"com.gcs.mcj.chat");
        /*TestWork1026.findTitle(device);
        TestWork1026.send1026(device);*/
       // TestWork1026.findListViewItem(device);
        TestUse1026.sleep(4000);
     //   KedouTest.Kedou100(device);
        TestUse1026.snapPic(device);
    }
}