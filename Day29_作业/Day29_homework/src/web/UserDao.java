package web;

import domain.User;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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

    public boolean match(String username,String password) {
        String sql = "select password from user where username =?";
        Connection conn = null;
        conn = JdbcUtil.getConnection();
        try {
            String query = qr.query(conn, sql, new ScalarHandler<String>(), username);
            if (query.equals(password)){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }





}
