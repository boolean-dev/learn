package com.tao.leanrn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName JDBCUtils
 * @Descriiption jdbc连接工具类
 * @Author yanjiantao
 * @Date 2019/6/28 16:24
 **/
public class JDBCUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = "root";
        String password = "root123456";

        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis-generator?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&serverTimezone=GMT%2B8", username, password);
    }


}
