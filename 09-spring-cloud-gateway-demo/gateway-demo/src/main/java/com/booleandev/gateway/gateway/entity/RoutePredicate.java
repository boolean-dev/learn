package com.booleandev.gateway.gateway.entity;

import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.support.NameUtils;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static org.springframework.util.StringUtils.tokenizeToStringArray;

/**
 * TODO
 *
 * @author Jiantao Yan
 * @title: RoutePredicate
 * @date 10/10/2020 4:36 PM
 */
public class RoutePredicate {

    @NotNull
    private String name;

    private Map<String, String> args = new LinkedHashMap<>();
    private String config;

    public RoutePredicate() {
    }

    public RoutePredicate(String text) {
        int eqIdx = text.indexOf('=');
        if (eqIdx <= 0) {
            throw new ValidationException("Unable to parse PredicateDefinition text '"
                    + text + "'" + ", must be of the form name=value");
        }
        setName(text.substring(0, eqIdx));

        String[] args = tokenizeToStringArray(text.substring(eqIdx + 1), ",");

        for (int i = 0; i < args.length; i++) {
            this.args.put(NameUtils.generateName(i), args[i]);
        }
        this.config = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }

    public void addArg(String key, String value) {
        this.args.put(key, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoutePredicate that = (RoutePredicate) o;
        return Objects.equals(name, that.name) && Objects.equals(args, that.args);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, args);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PredicateDefinition{");
        sb.append("name='").append(name).append('\'');
        sb.append(", args=").append(args);
        sb.append('}');
        return sb.toString();
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
