package com.acat.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    public static String Encrypt(String str){

        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] s = md.digest(str.getBytes());
            String ss = "";
            String result = "";
            for(int i=0;i<s.length;i++){
                ss = Integer.toHexString(s[i] & 0xff);
                if(ss.length()==1){
                    result+="0"+ss;
                }else {
                    result+=ss;
                }
            }
            return result;
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String convertMD5(String inStr){
        char[] a = inStr.toCharArray();
        for(int i=0;i<a.length;i++){
            a[i] = (char)(a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }


    public static void main(String[] args){
        String userName = "abc123l23";
        System.out.println("原始字符串："+userName);
        System.out.println("MD5后："+Md5Util.Encrypt(userName));
        System.out.println("加密后："+Md5Util.convertMD5(userName));
        System.out.println("解密后："+Md5Util.convertMD5(Md5Util.convertMD5(userName)));
    }
}
