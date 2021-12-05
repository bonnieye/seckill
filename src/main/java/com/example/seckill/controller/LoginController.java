package com.example.seckill.controller;

import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:yeqiuhan
 * @Date:2021-12-0512:00
 */
@Controller
@RequestMapping("/login")
@Slf4j
//输出日志
public class LoginController {
    /*
    跳转登陆页面
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    /**
     * 登录
     * @return
     */

    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo) {
        //因为Slf4j注解
        log.info("{}",loginVo);
        //log.info(loginVo.toString());
        return null;
        //return userService.login(loginVo);
    }
}
