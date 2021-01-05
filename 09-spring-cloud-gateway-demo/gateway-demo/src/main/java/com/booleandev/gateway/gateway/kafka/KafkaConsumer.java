package com.booleandev.gateway.gateway.kafka;

import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * kafka 消费者
 *
 * @author Jiantao Yan
 * @title: KafkaConsumer
 * @date 10/12/2020 10:02 AM
 */
@Slf4j
//@Component
public class KafkaConsumer implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

//    @KafkaListener(topics = "myTopic")
//    public void listen(ConsumerRecord<?, ?> cr) throws Exception {
//        log.info(cr.toString());
//    }
//
//
//    @KafkaListener(topics = "tocpic-refresh-route")
//    public void refreshRoute(ConsumerRecord<?, ?> cr) {
//        log.info("----------->refresh route");
//        this.publisher.publishEvent(new RefreshRoutesEvent(this));
//    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
