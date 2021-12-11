package com.example.seckill.controller;

import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IUserService;
import com.example.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author yeqiuhan
 * @date 2021-12-0519:35 商品
 */

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodsService;

    /**
     * 跳转登录页
     */
    @RequestMapping("/toList")
    public String toLogin(HttpServletRequest request, HttpServletResponse response, Model model, @CookieValue("userTicket") String ticket) {
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
        User user = userService.getUserByCookie(ticket, request, response);
        System.out.print("使用");
        System.out.print(user.getId());
        if (null == user) {
            return "login";
        }
        model.addAttribute("user", user);
        model.addAttribute("goodsList", goodsService.findGoodsVo());
        return "goodsList";
    }

    /**
     * 功能描述
     *
     * @return java.lang.String
     * @author tt
     * @date 2021/12/6
     */
    @RequestMapping("/toDetail/{goodsId}/{userid}")
    //这里跳转详情页不知道咋办user过不来，要不直接前端传个id过来算了
    public String toDetail(Model model,User user, @PathVariable Long goodsId,@PathVariable Long userid) {
        System.out.print("使用111");
        System.out.print(userid);
        model.addAttribute("user", user);
        System.out.print("使用222");
        System.out.print(user.getId());
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodsId);
        Date startDate = goodsVo.getStartDate();
        Date endDate = goodsVo.getEndDate();
        Date nowDate = new Date();
        // 秒杀状态
        int secKillStatus;
        // 秒杀倒计时
        int remainSeconds;
        // 秒杀还未开始
        if (nowDate.before(startDate)) {
            remainSeconds = ((int) ((startDate.getTime() - nowDate.getTime()) / 1000));
            secKillStatus = 0;
        } else if (nowDate.after(endDate)) {
            // 秒杀已经结束
            secKillStatus = 2;
            remainSeconds = -1;
        } else {
            // 秒杀中
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("remainSeconds", remainSeconds);
        model.addAttribute("secKillStatus", secKillStatus);
        model.addAttribute("goods", goodsVo);
        model.addAttribute("userid", userid);
        return "goodsDetail";
    }
}

