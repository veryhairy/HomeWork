package com.lanou3g.bookstore.user.dao;

import com.lanou.jdbc.JdbcUtils;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.UserService;
import com.lanou3g.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.jsp.jstl.sql.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public ResultSet queryByUsername(User forDb){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        connection = C3P0Util.getConnection();
        try {
            ps = connection.prepareStatement("SELECT * FROM USER where username =?");
            ps.setString(1,forDb.getUsername());
            resultSet = ps.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet queryByEmail(User user){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        connection = C3P0Util.getConnection();
        try {
            ps = connection.prepareStatement("SELECT * FROM USER where username =?");
            ps.setString(1,user.getPassword());
            resultSet = ps.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public void insert(User insert,String uid,String uuid){
        UserService userService = new UserService();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        connection = C3P0Util.getConnection();

        try {
            ps=connection.prepareStatement("INSERT INTO USER VALUES (?,?,?,?,?,1)");
            ps.setString(1,uid);
            ps.setString(2,insert.getUsername());
            ps.setString(3,insert.getPassword());
            ps.setString(4,insert.getEmail());
            ps.setString(5,uuid);
            ps.executeUpdate();
//           TODO 1表示false 2 表示true
//            获得1,5,
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,ps,connection);
        }

    }

    public void changeStatus(String code){
        UserService userService = new UserService();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        connection = C3P0Util.getConnection();
        try {
            ps=connection.prepareStatement("UPDATE USER SET state=2 WHERE code=?");
            ps.setString(1,code);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Util.release(resultSet,ps,connection);
        }
    }

    private QueryRunner qr = new QueryRunner();
    public User queryUid(String username){
           String sql="select * from user where username=?";
           Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            return qr.query(conn,sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
