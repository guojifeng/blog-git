package cn.guojifeng.blog.rocketmq.util;

import org.apache.rocketmq.client.exception.MQClientException;

public class RocketMQException extends RuntimeException {


    public RocketMQException(RocketMQErrorEnum parammNull, String groupName_is_blank, boolean b) {

    }

    public RocketMQException(MQClientException e) {

    }
}