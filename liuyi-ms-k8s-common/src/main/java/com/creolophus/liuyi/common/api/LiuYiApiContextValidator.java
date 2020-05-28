package com.creolophus.liuyi.common.api;

import com.creolophus.liuyi.common.exception.UnauthorizedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.http.HttpServletRequest;

/**
 * @author magicnana
 * @date 2019/12/20 下午1:51
 */
public class LiuYiApiContextValidator extends ApiContextValidator {


    public static final String SOMETHING="something";


    private static final Logger logger = LoggerFactory.getLogger(LiuYiApiContextValidator.class);

    public String getSomething(){
        return ApiContext.getContext().getExt().get(SOMETHING);
    }


    public String getExt4Logger(){
        String appKey = getSomething();

        appKey = StringUtils.isBlank(appKey)?"-":appKey;
        return appKey;
    }

    public void setSomething(String something) {
        ApiContext.getContext().setExt(SOMETHING, something);
        MDC.put(GlobalSetting.MDC_EXT, getExt4Logger());
    }

    public void validateSomething(HttpServletRequest request) {

        String appKey = request.getHeader(SOMETHING);

        if(StringUtils.isBlank(appKey)) {
            throw new UnauthorizedException("missing require header -"+SOMETHING);
        } else {
            setSomething(appKey);
        }
    }
}
