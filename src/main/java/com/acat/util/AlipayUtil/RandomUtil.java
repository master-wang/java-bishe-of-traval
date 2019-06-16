package com.acat.util.AlipayUtil;

import java.util.Random;

public class RandomUtil {

    public static String getRandom(){
        StringBuffer sb = new StringBuffer();
        Random ra =new Random();
        for(int i=0;i<25;i++){
            //list.add(ra.nextInt(10)+1);
            sb.append(ra.nextInt(10)+1);
        }
        return sb.toString();
    }

}
