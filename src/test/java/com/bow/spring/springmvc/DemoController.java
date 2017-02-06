package com.bow.spring.springmvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ViVi
 * @date 2015年9月7日 下午10:25:31
 */

@Controller
public class DemoController {

    @RequestMapping("/demo")
    public void getString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(">> access to DemoController");
        response.getWriter().println("<h1> demo </h1>");
    }

    @RequestMapping("/html")
    public ViewName htmlIndex(ModelMap modelMap) {
        modelMap.put("message", "hello world");
        ViewName viewName = new ViewName();
        viewName.setName("html");
        return viewName;
    }

    @RequestMapping("/customize")
    @MyResponseBody
    public ResponseData customize(@MyRequestBody RequestData requestData) {
        System.out.println(requestData);
        ResponseData responseData = new ResponseData();
        responseData.setData(requestData.getData());
        return responseData;
    }
}
