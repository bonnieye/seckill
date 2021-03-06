package com.example.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 公共返回对象枚举
 */
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    // 通用
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务端异常"),
    // 登录模块5002xx
    SESSION_ERROR(500210, "用户不存在或者已经失效"),
    LOGINVO_ERROR(500211, "用户名或者密码错误"),
    MOBILE_ERROR(500212, "手机号码格式错误"),
    BIND_ERROR(500213, "参数校验异常"),
    MOBILE_NOT_EXIST(500214, "手机号码不存在"),
    PASSWORD_UPDATE_FAIL(500215, "密码更新失败"),
    // 秒杀模块5005xx
    EMPTY_STOCK(500500, "库存不足"),
    REPEATE_ERROR(500501, "该商品每人限购一件"),
    // 订单模块5003xx
    ORDER_NOT_EXIST(500300, "订单信息不存在"),
    ;
    private final Integer code;     // 状态码
    private final String message;   // 相应信息
}
