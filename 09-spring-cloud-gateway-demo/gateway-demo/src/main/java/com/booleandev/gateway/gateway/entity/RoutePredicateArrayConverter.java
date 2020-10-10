package com.booleandev.gateway.gateway.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rjz
 */
public class RoutePredicateArrayConverter implements AttributeConverter<List<RoutePredicate>, String> {

    private ObjectMapper mapper = new ObjectMapper();

    private static final String EMPTY = "[]";

    private TypeReference<List<RoutePredicate>> typeReference = new TypeReference<>(){};
    @Override
    public String convertToDatabaseColumn(List<RoutePredicate> values) {
        try {
            return mapper.writeValueAsString(values);
        } catch (Exception e) {
            return EMPTY;
        }
    }

    @Override
    public List<RoutePredicate> convertToEntityAttribute(String json) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
