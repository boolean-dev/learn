package com.booleandev.gateway.gateway.dao;

import com.booleandev.gateway.gateway.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

/**
 * route 路由 dao
 *
 * @author Jiantao Yan
 * @title: RouteRepository
 * @date 10/10/2020 2:08 PM
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    Route findRouteByRouteId(String routeId);
}
