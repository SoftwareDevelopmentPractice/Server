package com.fhlxc.backend;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private Connection conn;
    
    public Connection getConnection() {
        return conn;
    }
    //connection
    public boolean connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + InetAddress.getByName("forever-happy").getHostAddress() + ":3306/taskshuntingsystem?useSSL=false&serverTimezone=GMT"
                    , "root", "zxc123__");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String ... args) {
        DB connectMySQL = new DB();
        if (connectMySQL.connect()) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }
    //ִupdate
    public int update(String sql)
    {
        System.out.println("sql: "+sql);
        try {
            Statement stmt = this.conn.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    //query
    public ResultSet query(String sql)
    {
        System.out.println("sql: "+sql);
        try {
            Statement stmt = this.conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
