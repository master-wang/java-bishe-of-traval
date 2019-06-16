package com.acat.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    public static String orderNum(){
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = df.format(now);
        return str;
    }
    public static void main(String[] args){
        String str = orderNum();
        System.out.println(str);
    }

}

