package com.immoc.util;


import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.Callable;

public class JDBCUtil {
    public static Connection getConnection() throws Exception {
//        String url="jdbc:mysql:///spring_data";
//        String user="root" ;
//        String password="root";
//        String driverClass="com.mysql.jdbc.Driver";
        //add test
       InputStream inputStream= JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        String url=properties.getProperty("jdbc.url");
        String user=properties.getProperty("jdbc.user");
        String password=properties.getProperty("jdbc.password");
        String driverClass=properties.getProperty("jdbc.diverClass");
        Class.forName(driverClass);
        Connection connection= DriverManager.getConnection(url,user,password);
        return connection;

    }
    /**
     * 释放 DB相关的资源
     * @param connection
     * @param resultSet
     * @param statement
     */
    public static  void release(ResultSet resultSet,
                                Statement statement, Connection connection) {
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    }





