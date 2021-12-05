package com.example.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:yeqiuhan
 * @Date:2021-12-0512:20
 * 公共返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private long code;
    private String message;
    private Object obj;
    //返回成功结果
    public static RespBean success(){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBean.success().getMessage(),null);
    }

    public static RespBean success(Object obj){
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),RespBean.success().getMessage(),obj);
    }
    //返回失败结果
    public static RespBean error(RespBeanEnum respBeanEnum){
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),null);
    }

    public static RespBean success(RespBeanEnum respBeanEnum,Object obj){
        return new RespBean(respBeanEnum.getCode(),respBeanEnum.getMessage(),obj);
    }
}
