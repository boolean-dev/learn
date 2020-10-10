package com.booleandev.gateway.gateway.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author rjz
 */
public class RouteFilterArrayConverter implements AttributeConverter<List<RouteFilter>, String> {

    private ObjectMapper mapper = new ObjectMapper();

    private static final String EMPTY = "[]";

    private TypeReference<List<RouteFilter>> typeReference = new TypeReference<>(){};
    @Override
    public String convertToDatabaseColumn(List<RouteFilter> values) {
        try {
            return mapper.writeValueAsString(values);
        } catch (Exception e) {
            return EMPTY;
        }
    }

    @Override
    public List<RouteFilter> convertToEntityAttribute(String json) {
        try {
            return mapper.readValue(json, typeReference);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
