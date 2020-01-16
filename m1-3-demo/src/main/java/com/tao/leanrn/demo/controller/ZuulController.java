package com.tao.leanrn.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiantao Yan
 * @description: 测试zuul
 * @title: ZuulController
 * @date 2020/1/15 18:20
 */
@Slf4j
@RestController
public class ZuulController {

    @GetMapping("/api/user/{id}")
    public Object zuul(@PathVariable(name = "id") String id) throws InterruptedException {
        log.info("------------------>开始时间");
        Thread.sleep(26000);
        log.info("------------------>结束时间");
        Map<String, Object> result = new HashMap<>(2);
        result.put("code",200);
        result.put("msg", "ZUUL转发成功!");
        result.put("userId", id);

        return result;

    }


    @GetMapping("/test/user/{id}")
    public Object omsTest(@PathVariable(name = "id") String id) throws InterruptedException {
        log.info("------------------>开始时间");
        Thread.sleep(61000);
        log.info("------------------>结束时间");
        Map<String, Object> result = new HashMap<>(2);
        result.put("code",200);
        result.put("msg", "ZUUL转发成功!");
        result.put("userId", id);

        return result;

    }
}
