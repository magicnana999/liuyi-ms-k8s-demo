package com.creolophus.liuyi.controller;

import com.creolophus.liuyi.common.api.ApiResult;
import com.creolophus.liuyi.common.base.AbstractController;
import com.creolophus.liuyi.feign.HelloFeign;
import com.creolophus.liuyi.feign.HelloFeign2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author magicnana
 * @date 2020/5/27 上午10:05
 */
@Validated
@RestController
@RequestMapping(value = "/liuyi/consumer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConsumerController extends AbstractController {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Resource
    private HelloFeign helloFeign;
    @Resource
    private HelloFeign2 helloFeign2;


    @RequestMapping("/hello")
    @ResponseBody
    public ApiResult hello() {
        return new ApiResult(helloFeign.hello() +" -> "+helloFeign2.hello());
    }
}
