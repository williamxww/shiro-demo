package com.bow.spring.springmvc;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vv
 * @since 2017/2/3.
 */
@MyController
public class CustomizedController {
    @MyRequestMapping("/")
    @ResponseBody
    public Map index() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("result", "hello world");
        return map;
    }
}
