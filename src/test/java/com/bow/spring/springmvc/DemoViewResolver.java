package com.bow.spring.springmvc;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author vv
 * @since 2017/2/2.
 */
public class DemoViewResolver implements ViewResolver {

    private DemoHtmlView htmlView = new DemoHtmlView();

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        System.out.println("resolve view name");
        if (viewName.equals("html")) {
            return htmlView;
        }
        return null;
    }
}
