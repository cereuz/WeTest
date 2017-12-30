package com.onezao.wetest.KedouNew_1221;

import java.util.Random;

/**
 * Created by zneo on 2017/12/22.
 */

public class KedouNew_Method {
    //返回随机数方法
    public static int KedouNew_getRandom(int seed){
        Random random = new Random();
        int nextInt = random.nextInt(seed);
        return nextInt;
    }
}
