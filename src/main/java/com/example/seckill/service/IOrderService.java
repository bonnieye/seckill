package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.GoodsVo;
import com.example.seckill.vo.OrderDetailVo;

/**
 * 服务类
 *
 * @author tt
 * @since 2021-12-06
 */

public interface IOrderService extends IService<Order> {
    /**
     * 秒杀
     * @param user
     * @param goods
     * @return
     */
    Order seckill(User user, GoodsVo goods,Long userid);

    /**
     * 功能描述 订单详情
     * @author tt
     * @date 2021/12/13
     * @return com.example.seckill.vo.OrderDetailVo
     */
    OrderDetailVo detail(Long orderId);
}
