package com.lanou3g.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("src/jdbc.properties"));
            String drivername = prop.getProperty("driverName");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            database = prop.getProperty("database");
            Class.forName(drivername);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println
                    (e.getMessage()+"/n/t/t"+"请将配置文件jdbc.properties放置到src目录下");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String url;
    private static String user;
    private static String password;
    private static String database;


    public static Connection getConnection(){
        try {


            Connection con = DriverManager.getConnection(
                    url+database,user,password
            );
            return con;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void execute(ExecuteInter e){
        try {
            Connection conn = DriverManager.getConnection(url+database,user,password );
            e.execute(conn).close();
            conn.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
    public static void shoeRS(ResultSet rs){
        try {
            while (rs.next()){
                System.out.println(rs.getString(1)+"\t\t");
                System.out.println(rs.getString(2)+"\t\t");
                System.out.println(rs.getString(3)+"\t\t");
                System.out.println(rs.getString(4)+"\t\t");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
