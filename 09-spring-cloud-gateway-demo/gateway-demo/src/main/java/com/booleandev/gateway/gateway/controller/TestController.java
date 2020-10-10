package com.booleandev.gateway.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * gateway 测试接口
 *
 * @author Jiantao Yan
 * @title: TestController
 * @date 10/9/2020 3:23 PM
 */
@RestController
@RequestMapping("/api/gateway")
public class TestController {

    @GetMapping("/demo1")
    public Object demo1() {
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("url", "/api/gateway/demo");
        result.put("msg", "success");
        return result;
    }
}
