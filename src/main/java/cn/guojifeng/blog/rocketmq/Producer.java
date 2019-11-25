package cn.guojifeng.blog.rocketmq;





import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.Date;

public class Producer {

    public static void main(String[] args) throws MQClientException {

        DefaultMQProducer producer = new DefaultMQProducer("rmq-group");
//        producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
        producer.setVipChannelEnabled(false);
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.setInstanceName("producer");
        producer.start();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);  //每秒发送一次MQ
                Message msg = new Message("TopicA-test",// topic
                        "TagA",// tag
                        (new Date() + "Hello RocketMQ ,QuickStart" + i)
                                .getBytes()// body
                );
                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.shutdown();
    }
}