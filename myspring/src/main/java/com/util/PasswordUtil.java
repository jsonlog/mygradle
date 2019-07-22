package com.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
//import org.springframework.util.DigestUtils;
import java.io.UnsupportedEncodingException;

/**
 * @author jsonlog
 * @date 2019-07-19
 */
public class PasswordUtil {
    public static String hashAndEncodePassword(String password) {
        try {
            final byte[] md5 = DigestUtils.md5(password.trim().getBytes("UTF-8"));
            final byte[] base64 = Base64.encodeBase64(md5);
            final String hashedAndEncoded = new String(base64, "ASCII");
            return "{MD5}" + hashedAndEncoded;
        }catch (UnsupportedEncodingException e){

        }
        return "";
    }
    public static String hashAndEncodePasswordSHA(String password) {
        try {
            final byte[] sha = DigestUtils.sha1(password.trim().getBytes("UTF-8"));
            final byte[] base64 = Base64.encodeBase64(sha);
            final String hashedAndEncoded = new String(base64, "ASCII");
            return "{SHA}" + hashedAndEncoded;
        }catch (UnsupportedEncodingException e){

        }
        return "";
    }
}