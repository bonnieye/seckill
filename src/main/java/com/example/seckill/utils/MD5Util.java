package com.example.seckill.utils;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;

@Component
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";

    // 第一次加密
    public static String inputPassToFromPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    // 第二次加密
    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    // 后端调用
    public static String inputPassToDBPass(String inputPass, String salt) {
        String fromPass = inputPassToFromPass(inputPass);
        return formPassToDBPass(fromPass, salt);
    }

    // 测试用
    public static void main(String[] args) {
        //d3b1294a61a07da9b49b6e22b2cbd7f9
        System.out.println(inputPassToFromPass("123456"));
        //b7797cce01b4b131b433b6acf4add449
        System.out.println(formPassToDBPass("d3b1294a61a07da9b49b6e22b2cbd7f9", "1a2b3c4d"));
        //b7797cce01b4b131b433b6acf4add449
        System.out.println(inputPassToDBPass("123456", "1a2b3c4d"));
        //我们真正要调用的方法就是inputPassToDBPass方法
    }
}
