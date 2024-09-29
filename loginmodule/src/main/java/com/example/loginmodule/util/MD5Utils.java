package com.example.loginmodule.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangyanming
 * @version v_1.0.0
 * @description
 * @date 2020/4/17 10:04
 */
public class MD5Utils {

    /**
     * MD5编码
     *
     * @param plainText
     * @return
     */
    public static String encoderByMd5(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            re_md5 = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }
}
