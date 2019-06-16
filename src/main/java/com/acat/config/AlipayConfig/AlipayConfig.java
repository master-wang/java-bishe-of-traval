package com.acat.config.AlipayConfig;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {


    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016081600256970";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDGyIGuY0+EwHJ8bCkDyPtjS1U+e4vwnTDtzObvOdAzX2vVpEXJHc3+c6zA5LjbyRD/4yssl65WMEAnYEwWicICw/dqQxlXVrNztWwWmS9kAq5riTpHTr2yDeYWT5bp+96ch4GwBVspTzg13PyW0XWCe0/53vMxEAb1OiznWmq81276F6CZZTOCccDlUe9UCZVtMTapdKqpFFHNPswjUnt2x8y/JVNvrihyeOW8A7OMWz7jxvoaX1IbWciUi3DvyFFS4ufdPd6AYM6ijzFdMa3esI3UVXHTvqcwdfVV2Pkxan0NspTyY9HYEpKFAn59GO1tNCoIzVxhR2Uz/NKRdkVRAgMBAAECggEASNjX9WF9lae1DPXSPgncXnIQBjreeMoSUUNC6i5kpz7z1LJDxMVAZVxc1b+8IwdXTH8ipk/b2sgJ6qQ2nhfT2pGYTP/T/JbQYrn8p3dxz5PP+aarjdBEYkkHpet64bqkxPY/x5Le6o+WiN64TkjqaGvqTiavNq6p7hpotEwFS7h9ti15+tLcJKvh28+sjCY7zRHilgIfkTLCplhgqXZkBuEiz0z9Oo0z8LEDlZYubqe/TCMeWphX3lgzclZy1RCHHIiUsQl6piqzYaXmGk7pqucwhH5DAhVsa9k859LymHZ2S/8DNEHLZDeTRu4xn6oEau0oN6RNGvw01GTp+qET8QKBgQDyVux9etNyozEGqH2Naqf0g8VUKSgl05LRVa0Ni5DyyHJHakWmilNGUb3XjWAeu4MPz6DF9zfc6W3KBJ46lmcQ62QL+LfEM0jNQLQ5L/KEj94n3BMGrGPMsFreVwfTbND5QzMYCHSjVBcK/v1SyhOgFmvNEIlpcx3yOrEeSLlHNQKBgQDR/QtOsNBrMD2T0JSjGsyizk7XpAKSCYeOzW2e5PAm09IIhPAVs4Tf/0WvV3SK3KchkyipIoSPa3WChuj9ToZrBM5aLOBIPucbLysTSpSYLOJ/8FIdNekgQu0Wc3uKKWxzXETOsAtuno5ae71i5Mq9c8I4062E//La54pVTjzdLQKBgHdFXsl3LSBrvxJW1MxIJPeL7w+33eGYGtdagnx7J1DGZLBPVo5b4BZo3rV7CEa35Q5gEvG79cuNO5LE6RdOtNU39RqLQ+6Viwwx/0FyHrstj5owj1CmgcvZNC/fx6NAGC3F7By09Kr6FQk9bHJVsIkG3/GiZO74UFHKnyeXhVDNAoGBAMbkgGNGQgJkrM5mz4I1jgHemvrQ08Zy1DzEAsJvYa/FDbkYATbs1Dw900ki8rXcDUlV0ztwAFK/m4vIMMJMMDEJWlI7EywauFcdNBWPnHMOgHJhs8ULHQZ7nYiYVTklxxz1Fg8W250o/PhjH5ydzBHppNqiVEYXD3WbvYDTG/75AoGANo65AhL0cNvHPRjf8hb8aIb1kgxNKlW64w8rz+DmeGd44fNjCtrkHuHOYpnnoiLjEyUG5Rbn0s8K4hCkJ9UuC7jrBMwprYVJNqEEHyR7b/Gk9RuzASW8zvQ9IxaE8P8xmyEu2TlUMe0dQvBdFIJE1hG6IGZKV8xzrT9VvyCa8oQ=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxQWr9CMQg8YTM60rgm45bMChYEPTnbBRehgI6I4QQ5GJyyd0kAGxBWIk8INv3yIKD9zV2HO9EDO/KmL0l/MkhzrDU/7fwWNDHsz2OA67HoCCYXztoEsAtMYYXe+eRH44w6eBRpCU5emUTR2IhJs5ZlXuzM0VVdUy+6lGkMbZB96Ip9C6WZuoK22+c+M22UQ0P174UTkEugnd4+wccUN2Ujh1Pl2YXmP66ZPs1yPCNHJeI8CVz2htSkc/RK73+mSFL0JskFX0+nBRIQyztacsZ5S9HwKFqs7AnfTObbVAlJTE1u8jz9mydQM0yWnsQx1nDutszkH3yIMlfcf2eBgoDwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/AlipayTest/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/AlipayTest/return.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/opt";


    //↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
