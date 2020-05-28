package com.creolophus.liuyi.boot;

import com.creolophus.liuyi.common.api.ApiInterceptor;
import com.creolophus.liuyi.common.api.ApiResult;
import com.creolophus.liuyi.common.api.LiuYiApiContextValidator;
import com.creolophus.liuyi.common.api.WebStart;
import com.creolophus.liuyi.common.swagger.LiuYiDocket;
import com.fasterxml.classmate.types.ResolvedObjectType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2018/11/9 下午4:49
 */

@SpringBootApplication(scanBasePackages = "com.creolophus",exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients(basePackages = "com.creolophus.liuyi.feign")
@EnableSwagger2
@EnableScheduling
@EnableAsync
public class Start extends WebStart {

    private static final Logger logger = LoggerFactory.getLogger(Start.class);


    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }

    @Bean
    public Docket docket(ApiInfo apiInfo) {

        List<Parameter> pars = new ArrayList();
        pars.add(LiuYiDocket.something());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.creolophus"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars)
                .additionalModels(
                        ResolvedObjectType.create(ApiResult.class,null,null,null));

    }

    @Override
    public ApiInterceptor apiInterceptor() {
        return new ApiInterceptor(){
            @Override
            protected void preHandle(HttpServletRequest request) {
                ((LiuYiApiContextValidator)apiContextValidator).validateSomething(request);
            }
        };
    }

    @Override
    public LiuYiApiContextValidator apiContextValidator(){
        return new LiuYiApiContextValidator();
    }

}