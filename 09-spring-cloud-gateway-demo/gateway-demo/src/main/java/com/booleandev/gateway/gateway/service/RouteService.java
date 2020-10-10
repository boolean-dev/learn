package com.booleandev.gateway.gateway.service;

import com.booleandev.gateway.gateway.dao.RouteRepository;
import com.booleandev.gateway.gateway.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 路由 service
 *
 * @author Jiantao Yan
 * @title: RouteService
 * @date 10/10/2020 2:23 PM
 */

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    public Route insert(Route route) {
        return routeRepository.save(route);
    }

    public Route update(Route route) {
        return routeRepository.save(route);
    }

    public Route findByRouteId(String routeId) {
        return routeRepository.findRouteByRouteId(routeId);
    }

    public Route findById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        Route route = routeRepository.findById(id).orElseThrow(null);
        routeRepository.delete(route);
    }




}
