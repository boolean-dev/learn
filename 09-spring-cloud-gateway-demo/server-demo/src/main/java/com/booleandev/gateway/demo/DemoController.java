package com.booleandev.gateway.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo COntroller
 *
 * @author Jiantao Yan
 * @title: DemoController
 * @date 10/9/2020 2:17 PM
 */
@RestController
public class DemoController {

    @GetMapping("/test1/demo1")
    public Object demo1() {
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("url", "/test1/demo1");
        result.put("msg", "服务端返回结果");
        return result;
    }

    @GetMapping("/test2/demo1")
    public Object demo2() {
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("url", "/test2/demo1");
        result.put("msg", "服务端返回结果");
        return result;
    }

    @GetMapping("/test2/demo2")
    public Object demo22() {
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("url", "/test2/demo2");
        result.put("msg", "服务端返回结果");
        return result;
    }

    @GetMapping("/test3/demo1")
    public Object demo3() {
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("url", "/test3/demo1");
        result.put("msg", "服务端返回结果");
        return result;
    }
}
