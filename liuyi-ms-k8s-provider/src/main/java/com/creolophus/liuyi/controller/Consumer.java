package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.api.ApiResult;
import com.creolophus.liuyi.common.logger.Entry;
import com.creolophus.liuyi.common.rocketmq.RocketMQConsumer;
import com.jsoniter.JsonIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author magicnana
 * @date 2020/8/6 下午6:20
 */
@Service
public class Consumer extends RocketMQConsumer {

    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Override
    protected String getConsumerGroup() {
        return "liuyi-ms-k8s-demo-group";
    }

    @Override
    protected String getConsumerTopic() {
        return "liuyi-ms-k8s-demo-topic";
    }

    @Override
    protected void process(String msgId, String topic, String msgBody, int times) {
        ApiResult result = JsonIterator.deserialize(msgBody,ApiResult.class);
        System.out.println(result.getCode());
        logger.info(msgBody );

    }
}
