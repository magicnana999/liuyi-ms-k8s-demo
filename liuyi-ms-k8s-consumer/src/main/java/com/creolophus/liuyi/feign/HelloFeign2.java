package com.creolophus.liuyi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author magicnana
 * @date 2018/12/20 下午4:00
 */
@FeignClient(value = "liuyi-ms-k8s-provider",url = "s5:30080")        //via ingress
public interface HelloFeign2 {

    @RequestMapping(value = "/liuyi/provider/hello",method = RequestMethod.GET)
    String hello();

}
