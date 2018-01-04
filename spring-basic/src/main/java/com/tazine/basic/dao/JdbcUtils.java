package com.tazine.basic.dao;

import java.sql.*;

/**
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
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo","root","");
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM CUSTOMER");

            while (rs.next()){
                System.out.println(rs.getString("name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
