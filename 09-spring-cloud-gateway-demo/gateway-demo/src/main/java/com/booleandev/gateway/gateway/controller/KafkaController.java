package com.booleandev.gateway.gateway.controller;

import com.booleandev.gateway.gateway.entity.Route;
import com.booleandev.gateway.gateway.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: Kafka
 * @date 10/12/2020 10:09 AM
 */

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    private KafkaProducer producer;


    @GetMapping("/send")
    public Object send() {
        producer.send();

        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("url", "/api/gateway/demo");
        result.put("msg", "success");
        return result;
    }

    @GetMapping("/route/refresh")
    public Object refreshRoute() {
        producer.refreshRoute();

        Map<String,Object> result = new HashMap<>();
        result.put("code", 200);
        result.put("url", "/api/route/refresh");
        result.put("msg", "success");
        return result;
    }
}
