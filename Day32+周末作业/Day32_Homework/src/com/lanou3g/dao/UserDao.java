package com.lanou3g.dao;

import com.lanou3g.domain.User;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.lanou3g.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private QueryRunner qr = new QueryRunner();

    public void insertUser(User user){
        String sql = "insert into user values(null,?,?)";
        Connection conn = null;

        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);

    }

    public User queryByUsername(String username) {
        String sql = "select * from user where username=?";
        Connection conn = JdbcUtil.getConnection();
        User user = new User();
        try {
            user=qr.query(conn,sql,new BeanHandler<User>(User.class),username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }}