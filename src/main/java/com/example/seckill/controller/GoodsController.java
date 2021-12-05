package com.example.seckill.controller;
import com.example.seckill.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;


/**
 * @Author:yeqiuhan
 * @Date:2021-12-0519:35
 * 商品
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    /**
     * 跳转登录页
     */
    @RequestMapping("/toList")
    public String toLogin(Model model, User user) {
        /**
         * 跳转到商品列表页
         */
//        if (StringUtils.isEmpty(ticket)) {
//            return "login";
//        }
//        User user = (User) session.getAttribute(ticket);
//        if (null == user) {
//            return "login";
//        }
        model.addAttribute("user", user);
        return "goodsList";
    }
}

