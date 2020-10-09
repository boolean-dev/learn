package com.tao.leanrn.mybatis.handler;

import com.tao.leanrn.mybatis.annotation.Delete;
import com.tao.leanrn.mybatis.annotation.Insert;
import com.tao.leanrn.mybatis.annotation.Select;
import com.tao.leanrn.mybatis.annotation.Update;
import com.tao.leanrn.mybatis.entity.User;
import com.tao.leanrn.utils.JDBCUtils;
import com.tao.leanrn.utils.ResultToMapper;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DaoOperatorHandler
 * @Descriiption 数据库操作处理器
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
        // 更新
        }else if (method.isAnnotationPresent(Update.class)) {
            sql = checkSql(method.getAnnotation(Update.class).value(), Update.class.getSimpleName());
            return update(sql, parameters);
        // 查询
        }else if (method.isAnnotationPresent(Select.class)) {
            sql = checkSql(method.getAnnotation(Select.class).value(), Select.class.getSimpleName());
            Class returnType = method.getReturnType();
            if (List.class.isAssignableFrom(returnType)) {
                return  selectMany(sql, parameters);
            }else {
                return selectMany(sql, parameters).get(0);
            }

        }else if (method.isAnnotationPresent(Delete.class)) {
            sql = checkSql(method.getAnnotation(Delete.class).value(), Delete.class.getSimpleName());
            return update(sql, parameters);
        }
        System.out.println(sql);
        return null;
    }

    /**
     * 插入
     * @param sql sql
     * @param parameters    参数
     * @throws SQLException SQLException
     * @throws ClassNotFoundException   ClassNotFoundException
     */
    private static void insert(String sql, Object[] parameters) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =  connection.prepareStatement(sql);
        for (int i = 0; i < parameters.length; i++) {
            statement.setObject(i+1, (String) parameters[i]);
        }
        statement.execute();
        connection.close();
    }

    /**
     * 插入
     * @param sql sql
     * @param parameters    参数
     * @throws SQLException SQLException
     * @throws ClassNotFoundException   ClassNotFoundException
     */
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

    /**
     * 插入
     * @param sql sql
     * @param parameters    参数
     * @return List<T>
     * @throws SQLException SQLException
     * @throws ClassNotFoundException   ClassNotFoundException
     */
    private static  <T> List<T> selectMany(String sql, Object[] parameters) throws SQLException, ClassNotFoundException {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement statement =  connection.prepareStatement(sql);
        for (int i = 0; parameters != null && i < parameters.length; i++) {
            statement.setObject(i+1, parameters[i]);
        }
        ResultSet resultSet = statement.executeQuery();
        List<T> result = new ResultToMapper<T>().mapToObject(resultSet,User.class);
        return result;
    }


    /**
     * 检查sql
     * @param sql   sql
     * @param type  type
     * @return  the sql
     * @throws SQLException SQLException
     */
    private static String checkSql(String sql, String type) throws SQLException {
        String sqlType = sql.split(" ")[0];
        if (!sqlType.equalsIgnoreCase(type)) {
            throw new SQLException("SQL语句错误");
        }
        return sql;
    }

}
