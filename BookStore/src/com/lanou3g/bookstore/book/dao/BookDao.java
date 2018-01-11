package com.lanou3g.bookstore.book.dao;

import com.lanou.jdbc.JdbcUtils;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.domain.Category;
import com.lanou3g.bookstore.user.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.*;
import java.util.List;

public class BookDao {
    public ResultSet queryAll() throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        connection = C3P0Util.getConnection();
        try {
            ps=connection.prepareStatement("SELECT * FROM book");
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet queryByCid(String cid) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        connection = C3P0Util.getConnection();
        try {
            ps=connection.prepareStatement("SELECT * FROM book WHERE cid =?");
            ps.setString(1,cid);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    QueryRunner qr = new QueryRunner();
    public Book queryByBid(String bid) {
        String sql = "select * from book where bid=?";
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
            return qr.query(conn, sql, new BeanHandler<Book>(Book.class), bid);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<Category> queryAllCategory() throws SQLException {
        QueryRunner qr = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from category";
        List<Category> query = qr.query(connection, sql, new BeanListHandler<Category>(Category.class));
        connection.close();
        return query;

    }
}
