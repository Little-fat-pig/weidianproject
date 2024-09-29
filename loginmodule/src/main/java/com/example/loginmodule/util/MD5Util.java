package com.example.loginmodule.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhangxueliang7
 * @version 1.0
 * @date 2023/6/2 14:01
 */
public class MD5Util {

    public final static String MD5(String s) {
        //结果字符串
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(s.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0){
                    i += 256;
                }
                if (i < 16){
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + s + ",32小写) = " + result);
            System.out.println("MD5(" + s + ",32大写) = " + result.toUpperCase());
            System.out.println("MD5(" + s + ",16小写) = " + buf.toString().substring(8, 24));
            System.out.println("MD5(" + s + ",16大写) = " + buf.toString().substring(8, 24).toUpperCase());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String sign="11831"+"165961199122016940"+System.currentTimeMillis();

        String s = MD5(sign).toLowerCase();
        s="43565556";
        int length = s.length();

    }
}
