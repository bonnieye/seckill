package com.example.seckill.rabbitmq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author:yeqiuhan
 * @Date:2021-12-1319:19
 */
@Service
@Slf4j
public class MQSender {

        @Autowired
        private RabbitTemplate rabbitTemplate;
            public void sendsecKillMessage(String message) {
                log.info("发送消息：" + message);
                rabbitTemplate.convertAndSend("seckillExchange", "seckill.msg", message);
            }
}
