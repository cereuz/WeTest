package com.onezao.wetest.testutils;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.test.InstrumentationRegistry;

/**
 * Created by XYL-SJ005 on 2018/3/6.
 */

public class TestWifi {
    /**
     * 是否开启 wifi true：开启 false：关闭
     *
     * @param isEnable
     */
    public static void setWifi(boolean isEnable) {
        WifiManager mWm = (WifiManager) InstrumentationRegistry.getContext().getSystemService(Context.WIFI_SERVICE);;
        //
        if (mWm == null) {
            return;
        }
        if (isEnable) {// 开启wifi

            if (!mWm.isWifiEnabled()) {

                mWm.setWifiEnabled(true);

            }
        } else {
            // 关闭 wifi
            if (mWm.isWifiEnabled()) {
                mWm.setWifiEnabled(false);
            }
        }

    }
}
