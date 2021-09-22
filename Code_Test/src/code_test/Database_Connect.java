/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author top1z
 */
public class Database_Connect {

    public static Connection Database(String db) throws SQLException, ClassNotFoundException {
        String user = "sa";
        String pass = "123";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String url = "jdbc:sqlserver://localhost:1433;databaseName=" + db;
        Connection cn = DriverManager.getConnection(url, user, pass);
        System.out.println("ok");
        return cn;

    }
}
