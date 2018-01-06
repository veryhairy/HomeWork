package com.lanou3g.dao;

import com.lanou3g.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.lanou3g.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {
    private QueryRunner qr = new QueryRunner();

    public void insert(Book book){
        String sql = "insert into book values(?,?,?)";
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            qr.update(conn,sql,book.getBkname(),book.getAuthor(),book.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);

    }
    public List<Book> queryAll() {
        String sql = "select * from book ";
        Connection conn = JdbcUtil.getConnection();
        List<Book> query=null;
        try {
            query= qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  query;

    }
}
