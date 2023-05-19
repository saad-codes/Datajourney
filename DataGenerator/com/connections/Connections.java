package com.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Connections {
    private Connection connect = null;
    private Statement statement = null;

    // private PreparedStatement preparedStatement = null;
    // private ResultSet resultSet = null;

    // public void readDataBase() {
    //     try {
    //         // This will load the MySQL driver, each DB has its own driver
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         // Setup the connection with the DB
    //         connect = DriverManager
    //                 .getConnection("jdbc:mysql://localhost:3306/classicmodels?"
    //                         + "user=root&password=Saad786b");
    //         System.out.println("ok");

    //         // Statements allow to issue SQL queries to the database
    //         statement = connect.createStatement();
    //         // Result set get the result of the SQL query
    //         resultSet = statement
    //                 .executeQuery("select customer_id from classicmodels.customer");
    //         while (resultSet.next()) {
    //             System.out.println(resultSet.getInt(1));

    //             connect.isClosed();
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();

    //     }
    // }
    public Statement Mysql() {


        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("org.mariadb.jdbc.Driver");
//            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Class found");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sys", "root", "admin123");
            System.out.println("connected");


            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // // Result set get the result of the SQL query
            // resultSet = statement
            //         .executeQuery("select customer_id from classicmodels.customer");
            // while (resultSet.next()) {
            //     System.out.println(resultSet.getInt(1));

            //     connect.isClosed();
            // }
        } catch (Exception e) {
            System.out.println("Not working");
            e.printStackTrace();

        }
        return statement;

    }
}