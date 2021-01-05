package com.booleandev.gateway.gateway.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * kafka 生产者
 *
 * @author Jiantao Yan
 * @title: KafkaProducer
 * @date 10/12/2020 10:02 AM
 */
@Slf4j
//@Component
public class KafkaProducer {}/*{

    @Autowired
    private KafkaTemplate<String, String> template;


    public void send() {
        template.send("myTopic", "foo1");
        template.send("myTopic", "foo2");
        template.send("myTopic", "foo3");
//        latch.await(60, TimeUnit.SECONDS);
        log.info("All sent");

    }

    public void refreshRoute() {
        template.send("tocpic-refresh-route", "foo1");
        template.send("tocpic-refresh-route", "foo2");
        template.send("tocpic-refresh-route", "foo3");
//        latch.await(60, TimeUnit.SECONDS);
        log.info("All sent");

    }

}*/
