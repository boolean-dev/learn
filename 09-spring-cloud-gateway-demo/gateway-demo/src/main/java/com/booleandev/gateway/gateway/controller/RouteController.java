package com.booleandev.gateway.gateway.controller;

import com.booleandev.gateway.gateway.entity.Route;
import com.booleandev.gateway.gateway.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: RouteController
 * @date 10/10/2020 3:04 PM
 */
@RestController
@RequestMapping("/api/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping
    public Route save(@RequestBody Route route) {
        return routeService.insert(route);
    }

    @GetMapping
    public List<Route> all() {
        return routeService.findAll();
    }

    @GetMapping("/{id}")
    public Route get(Long id) {
        return routeService.findById(id);
    }

    @PutMapping
    public Route update(@RequestBody Route route) {
        return routeService.update(route);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id) {
        routeService.delete(id);
    }
}
