package com.example.seckill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.seckill.pojo.Order;

/**
 *  Mapper 接口
 * @author tantan
 * @since 2021-12-06
 */

public interface OrderMapper extends BaseMapper<Order> {

    int insert(Order order);
}
