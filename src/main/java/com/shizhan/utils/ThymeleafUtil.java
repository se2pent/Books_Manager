package com.shizhan.utils;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThymeleafUtil {
    private static final TemplateEngine ENGINE;
    static {
        ENGINE=new TemplateEngine();
        ClassLoaderTemplateResolver r=new ClassLoaderTemplateResolver();
        r.setCharacterEncoding("utf8");
        ENGINE.setTemplateResolver(r);
    }

    public static TemplateEngine getEngine(){
        return ENGINE;
    }
}
