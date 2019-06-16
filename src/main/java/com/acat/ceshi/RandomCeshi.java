package com.acat.ceshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCeshi {

    public static String getRandom(){
        StringBuffer sb = new StringBuffer();
        Random ra =new Random();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<25;i++){
            //list.add(ra.nextInt(10)+1);
            sb.append(ra.nextInt(10)+1);
        }
        return sb.toString();
    }
}
