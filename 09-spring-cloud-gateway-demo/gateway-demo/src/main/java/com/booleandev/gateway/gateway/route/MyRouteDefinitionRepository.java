package com.booleandev.gateway.gateway.route;

import com.booleandev.gateway.gateway.entity.Route;
import com.booleandev.gateway.gateway.service.RouteService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * route 动态加载
 *
 * @author Jiantao Yan
 * @title: MyRouteDefinitionRepository
 * @date 10/10/2020 2:33 PM
 */

@Slf4j
@Component
public class MyRouteDefinitionRepository implements RouteDefinitionRepository {

    @Autowired
    private RouteService routeService;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<Route> allRoute =  routeService.findAll();
        List<RouteDefinition> routeDefinitionList = new ArrayList<>(allRoute.size());
        Gson gson = new Gson();
        allRoute.forEach(route -> {
            List<FilterDefinition> filterDefinitions = new ArrayList<>();
            List<PredicateDefinition> predicateDefinitions = new ArrayList<>();
            route.getFilters().forEach(filter -> {
                FilterDefinition filterDefinition = new FilterDefinition();
                BeanUtils.copyProperties(filter, filterDefinition);
                filterDefinitions.add(filterDefinition);
            });
            route.getPredicates().forEach(predicate -> {
                PredicateDefinition predicateDefinition = new PredicateDefinition();
                BeanUtils.copyProperties(predicate, predicateDefinition);
                predicateDefinitions.add(predicateDefinition);
            });
//            BeanUtils.copyProperties(route.getFilters(), filterDefinitions);
//            BeanUtils.copyProperties(route.getPredicates(), predicateDefinitions);
            RouteDefinition routeDefinition = new RouteDefinition();
            routeDefinition.setId(route.getRouteId());
            routeDefinition.setOrder(route.getOrder());
            routeDefinition.setUri(URI.create(route.getUri()));
            routeDefinition.setFilters(filterDefinitions);
            routeDefinition.setPredicates(predicateDefinitions);
            routeDefinitionList.add(routeDefinition);
        });
        return Flux.fromIterable(routeDefinitionList);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return Mono.empty();
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return Mono.empty();
    }
}
