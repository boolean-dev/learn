package com.booleandev.gateway.gateway.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: RouteHandler
 * @date 10/10/2020 2:21 PM
 */

@Slf4j
@Service
public class RouteHandler implements ApplicationEventPublisherAware, CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }
}
