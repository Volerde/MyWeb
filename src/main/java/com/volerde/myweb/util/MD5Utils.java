package com.volerde.myweb.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The type Md 5 utils.
 *
 * @author Volerde
 * @date 2021 /8/18 22:54
 */
public class MD5Utils {

    /**
     * Code string.
     *
     * @param str the str
     * @return the string
     */
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buffer = new StringBuffer("");
            for(int offset = 0; offset < byteDigest.length; offset++){
                i=byteDigest[offset];
                if(i < 0){i += 256;}
                if(i<16){buffer.append("0");}
                buffer.append(Integer.toHexString(i));
            }
//            32位加密
            return buffer.toString();
//            16位加密
//            return buffer.toString().substring(8,24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
