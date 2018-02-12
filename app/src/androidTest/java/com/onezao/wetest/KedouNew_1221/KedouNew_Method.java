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

        //返回手机号码，只需要一个就可以的
        public static String KedouNew_getPhone() {
            String  number = "1";//定义电话号码以1开头
//        for (int i = 0; i < 9; i++) {//9代表循环九次，产生九个随机号码
            Random random = new Random();//定义random，产生随机数
            for (int j = 0; j < 10; j++) {
                //生成0~9 随机数
                number += random.nextInt(9);
            }
//        }
            return  number;
        }

        //获取四个，六个字符的验证码
        public static String KedouNew_getVeriCode(int length){
            Random random = new Random();//定义random，产生随机数\
            String  number = "1";
            for (int j = 0; j < length; j++) {
                //生成0~9 随机数
                number += random.nextInt(9);
            }
            return  number;
        }

    }
