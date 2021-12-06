package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.Goods;
import com.example.seckill.vo.GoodsVo;

import java.util.List;

/**
 *  服务类
 *
 * @author tt
 * @date 2021-12-06
 */
public interface IGoodsService extends IService<Goods> {
    /**
     * 获取商品列表
     */
    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
