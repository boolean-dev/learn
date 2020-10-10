package com.booleandev.gateway.gateway.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 路由实体类
 *
 * @author Jiantao Yan
 * @title: Route
 * @date 10/10/2020 2:03 PM
 */

@Data
@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeId;

    @Column(name = "`order`")
    private Integer order;

    private String uri;

    @Convert(converter = RoutePredicateArrayConverter.class)
    private List<RoutePredicate> predicates;

    @Convert(converter = RouteFilterArrayConverter.class)
    private List<RouteFilter> filters;
}
