package com.example.seckill.utils;

import java.util.UUID;

/**
 * @Author:yeqiuhan
 * @Date:2021-12-0519:24
 */
public class UUIDUtil {
    /**
     * UUID工具类
     *
     */
        public static String uuid() {
            return UUID.randomUUID().toString().replace("-", "");
        }
}
