package com.epidemic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class EpidemicApplication extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //spring的配置类
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        //springmvc的配置类
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        //返回映射到dispatcherService的请求路径
        return new String[]{"/"};
    }
}
