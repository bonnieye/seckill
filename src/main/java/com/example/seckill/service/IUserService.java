package com.example.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.seckill.pojo.User;
import com.example.seckill.vo.LoginVo;
import com.example.seckill.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yeqiuhan
 * @since 2021-12-05
 */
public interface IUserService extends IService<User> {
/**
 * 登录
 */
    RespBean login(LoginVo loginVo);

}
