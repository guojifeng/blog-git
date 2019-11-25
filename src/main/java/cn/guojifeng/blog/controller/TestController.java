package cn.guojifeng.blog.controller;

import cn.guojifeng.blog.rocketmq.test.service.TestService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/testRocketMQProduce")
    public String testRocketMQProduce(String message) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        return testService.testRocketMQProduce(message);
    }
}