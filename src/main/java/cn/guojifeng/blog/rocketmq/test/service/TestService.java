package cn.guojifeng.blog.rocketmq.test.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class TestService {

    @Value("${rocketmq.consumer.topics}")
    private String topics;

    @Value("${rocketmq.consumer.tag}")
    private String tag;

    @Resource
    private DefaultMQProducer defaultMQProducer;


    public String testRocketMQProduce(String message) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message msg = new Message(topics,// topic
                tag,// tag
                (new Date() + message).getBytes()// body
        );
        SendResult sendResult = defaultMQProducer.send(msg);
        return message;
    }

}