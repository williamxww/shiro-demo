package com.bow.spring.springmvc;

import com.bow.spring.springmvc.viewResolver.DemoController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @see DispatcherServlet#initStrategies(org.springframework.context.ApplicationContext)
 * @author vv
 * @since 2017/2/2.
 */
@Configuration
public class MvcTest {

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        return new RequestMappingHandlerAdapter();
    }

    @Bean
    public DemoController demoController() {
        return new DemoController();
    }

    @Test
    public void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MvcTest.class);
        RequestMappingHandlerMapping handlerMapping = context.getBean(RequestMappingHandlerMapping.class);
        RequestMappingHandlerAdapter handlerAdapter = context.getBean(RequestMappingHandlerAdapter.class);

        // build request
        MockHttpServletRequest request = new MockHttpServletRequest("POST", "/demo");
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setParameter("param", "aaa");
        request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);

        HandlerExecutionChain chain;
        ModelAndView model = null;
        try {
            chain = handlerMapping.getHandler(request);
            model = handlerAdapter.handle(request, response, chain.getHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
