package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.api.ApiResult;
import com.creolophus.liuyi.common.base.AbstractController;
import com.creolophus.liuyi.common.rocketmq.RocketMQProducer;
import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author magicnana
 * @date 2020/5/27 上午10:05
 */
@Validated
@RestController
@RequestMapping(value = "/liuyi/provider", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProviderController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(ProviderController.class);

    @Resource
    private RocketMQProducer producer;

    @RequestMapping("/hello")
    public ApiResult hello() {
        String msg = "Hello Kubernetes,I am liuyi-ms-k8s-provider " + System.currentTimeMillis();
        logger.info("output： " + msg);
        return new ApiResult(msg);
    }

    @RequestMapping("/send")
    public ApiResult<String> sendMQ(){
        ApiResult result = new ApiResult(new ApiResult("helloworld"));
        producer.send("liuyi-ms-k8s-demo-topic", JsonStream.serialize(result).getBytes());
        return new ApiResult<>("OK");
    }

}
