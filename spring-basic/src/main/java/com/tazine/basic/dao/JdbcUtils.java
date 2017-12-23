package com.tazine.basic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author frank
 * @since 1.0.0
 */
public class JdbcUtils {


    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
