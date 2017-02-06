package com.bow.spring.springmvc;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author vv
 * @since 2017/2/2.
 */
public class DemoResponseBodyReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
//        return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), DemoResponseBody.class) || returnType.hasMethodAnnotation(DemoResponseBody.class));
        return false;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

    }
}
