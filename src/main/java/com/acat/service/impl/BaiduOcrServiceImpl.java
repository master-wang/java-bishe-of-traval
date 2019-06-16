package com.acat.service.impl;

import com.acat.service.BaiduOcrService;
import com.acat.util.BaiduOcrUtil.BaiduUtil;
import com.acat.util.BaiduOcrUtil.Base64Util;
import com.acat.util.BaiduOcrUtil.FileUtil;
import com.acat.util.BaiduOcrUtil.HttpUtil;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;

@Service("baiduOcrService")
public class BaiduOcrServiceImpl implements BaiduOcrService {

    private static final String BAIDU_OCR_URI = "https://aip.baidubce.com/rest/2.0/ocr/v1/general";

    private static final String BAIDU_API_KEY = "Gh8Ldr1HbtZVOSMMcGqmuZ6H";

    private static final String BAIDU_Secret_KEY = "7YuGe3QK4IqGiOjTGAPNDyHrUbokZ4aq";

    public String getBaiduOcr(String picUrl){

        String result = null;

        try{
            byte[] imgData = FileUtil.readFileByBytes(picUrl);
            String imgStr = Base64Util.encode(imgData);
            String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = BaiduUtil.getAuth(BAIDU_API_KEY, BAIDU_Secret_KEY);
            result = HttpUtil.post(BAIDU_OCR_URI, accessToken, params);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }


}
