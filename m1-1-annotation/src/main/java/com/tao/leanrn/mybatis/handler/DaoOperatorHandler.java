package com.tao.leanrn.mybatis.handler;

import com.tao.leanrn.mybatis.annotation.Delete;
import com.tao.leanrn.mybatis.annotation.Insert;
import com.tao.leanrn.mybatis.annotation.Select;
import com.tao.leanrn.mybatis.annotation.Update;
import com.tao.leanrn.utils.JDBCUtils;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DaoOperatorHandler
 * @Descriiption TODO
 * @Author yanjiantao
 * @Date 2019/6/27 11:39
 **/
public class DaoOperatorHandler {

    public static Object handle(Method method, Object[] parameters) throws SQLException, ClassNotFoundException {
        String sql = null;

        // 插入
        if (method.isAnnotationPresent(Insert.class)) {
            sql = checkSql(method.getAnnotation(Insert.class).value(), Insert.class.getSimpleName());
            insert(sql, parameters);

        }else if (method.isAnnotationPresent(Update.class)) {
            sql = checkSql(method.getAnnotation(Update.class).value(), Update.class.getSimpleName());
            return update(sql, parameters);
        }else if (method.isAnnotationPresent(Select.class)) {

        }else if (method.isAnnotationPresent(Delete.class)) {

        }
        System.out.println(sql);
        return null;
    }

    private static void insert(String sql, Object[] parameters) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =  connection.prepareStatement(sql);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i+1, (String) parameters[i]);
        }
        statement.execute();
        connection.close();
    }

    private static Integer update(String sql, Object[] parameters) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =  connection.prepareStatement(sql);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i+1, parameters[i]);
        }
        int result = statement.executeUpdate();
        connection.close();
        return result;
    }

    private static  <T> List<T> selectMany(String sql, Object[] parameters) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =  connection.prepareStatement(sql);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i+1, parameters[i]);
        }
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {

        }
    }

    private static String checkSql(String sql, String type) throws SQLException {
        String sqlType = sql.split(" ")[0];
        if (!sqlType.equalsIgnoreCase(type)) {
            throw new SQLException("SQL语句错误");
        }
        return sql;
    }

    private static String buildSql(String sql, Object[] paras) throws SQLException {
        for (Object para : paras) {
            sql.replaceFirst(para.toString(), "{}");
        }
        return sql;
    }
}
