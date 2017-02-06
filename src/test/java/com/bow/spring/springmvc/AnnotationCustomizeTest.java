package com.bow.spring.springmvc;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author vv
 * @since 2017/2/3.
 */
@Configuration
public class AnnotationCustomizeTest extends WebMvcConfigurationSupport {
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = super.requestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> converters = new ArrayList();
        converters.add(new DataMessageConvert());

        // ArgumentResolver
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList();
        argumentResolvers.add(new MyResolver(converters));
        requestMappingHandlerAdapter.setCustomArgumentResolvers(argumentResolvers);

        // ReturnValueHandler
        List<HandlerMethodReturnValueHandler> returnValueHandlers = new ArrayList();
        returnValueHandlers.add(new MyResolver(converters));
        requestMappingHandlerAdapter.setCustomReturnValueHandlers(returnValueHandlers);
        return requestMappingHandlerAdapter;
    }

    @Bean
    public DemoController demoController() {
        return new DemoController();
    }

    @Test
    public void test() throws Exception {
        MockServletContext mockServletContext = new MockServletContext();
        MockServletConfig mockServletConfig = new MockServletConfig(mockServletContext);
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AnnotationCustomizeTest.class);
        context.setServletConfig(mockServletConfig);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        dispatcherServlet.init(mockServletConfig);

        // mock
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/customize");
        request.addHeader("Accept", "application/json");
        request.setContent(("result,hello world;date," + Calendar.getInstance().getTimeInMillis()).getBytes());
        dispatcherServlet.service(request, response);
        System.out.println(">>>"+new String(response.getContentAsByteArray()));
    }
}
