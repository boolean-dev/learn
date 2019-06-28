package com.tao.leanrn.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ResultToMapper
 * @Descriiption TODO
 * @Author yanjiantao
 * @Date 2019/6/28 17:35
 **/
public class ResultToMapper<T> {

    public List<T> mapToObject(ResultSet resultSet, Class<T> clazz) throws SQLException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        if (resultSet == null) {
            return null;
        }

        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
            T bean = (T) clazz.newInstance();
            ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i + 1);
                Object columnValue = resultSet.getObject(i + 1);
                Field field = clazz.getDeclaredField(columnName);
                if (field != null && columnValue != null) {
                    field.set(columnName,columnValue);
                }
            }
        }
    }

}
