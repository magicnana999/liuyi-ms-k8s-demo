package com.creolophus.liuyi.common.swagger;

import com.creolophus.liuyi.common.api.LiuYiApiContextValidator;
import springfox.documentation.service.Parameter;

/**
 * @author magicnana
 * @date 2019/12/20 下午1:48
 */
public class LiuYiDocket extends SwaggerDocket {

    public static Parameter something() {
        return header(LiuYiApiContextValidator.SOMETHING,true,"be7fcee88904a31d40064240ac13d931");
    }

}
