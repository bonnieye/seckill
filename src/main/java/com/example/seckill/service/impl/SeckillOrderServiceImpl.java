package com.example.seckill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.seckill.mapper.OrderMapper;
import com.example.seckill.mapper.SeckillOrderMapper;
import com.example.seckill.pojo.Order;
import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.pojo.User;
import com.example.seckill.service.ISeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2021-12-06
 */
@Service
public class SeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 获取秒杀结果
     *
     * @param user
     * @param goodsId
     * @return 成功 -1：失败；0：排队中
     */
    @Override
    public Long getResult(User user, Long goodsId) {
        Order order = orderMapper.selectOne(new
                QueryWrapper<Order>().eq("user_id", user.getId()).eq("goods_id",
                goodsId));
        if (null != order) {
            return order.getId();
        } else {
            if (redisTemplate.hasKey("isStockEmpty:" + goodsId)) {
                //库存已经为空
                return -1L;
            }else {
                return 0L;
            }
        }
    }
}