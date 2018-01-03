package dao;

import domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import util.JdbcUtil;

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
            qr.update(conn,sql,book.getBname(),book.getAuthor(),book.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(conn);
    }
    public List query(){
        String sql = "select * from book";
        Book book = null;
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            List<Book> bks = qr.query(conn, sql, new BeanListHandler<Book>(Book.class));
            return bks;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
