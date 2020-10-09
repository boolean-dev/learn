package com.booleandev.gateway.demo;

import org.springframework.web.bind.annotation.GetMapping;
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
@RestController("/test")
public class DemoController {

    @GetMapping("/demo1")
    public Object demo1() {
        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("url", "/test/demo");
        result.put("msg", "success");
        return result;
    }
}
