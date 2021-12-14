package com.example.seckill.controller;
import com.example.seckill.pojo.User;
import com.example.seckill.rabbitmq.MQSender;
import com.example.seckill.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Controller

@RequestMapping("/user")
public class UserController {
    @Autowired
    private MQSender mqSender;
    /**
     * 用户信息(测试)
     * @param user
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public RespBean info(User user){
        return RespBean.success(user);
    }

//    /**
//     * 测试发送RabbitMQ消息
//     */
//    @RequestMapping("/mq/fanout")
//    @ResponseBody
//    public void mq() {
//        mqSender.send("Hello");
//    }
//
//    /**
//     * 测试发送RabbitMQ消息
//     */
//    @RequestMapping("/mq/direct01")
//    @ResponseBody
//    public void mq01() {
//        mqSender.send01("Hello,Red");
//    }
//    @RequestMapping("/mq/direct02")
//    @ResponseBody
//    public void mq02() {
//        mqSender.send02("Hello,Green");
//    }
}
