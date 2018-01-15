package dao;

import bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by fwj on 2018/1/15.
 */
public class UserDao {

    QueryRunner qr = new QueryRunner();
    public void insert(User user) throws SQLException {
        String sql = "insert into user values(?,?)";
        Connection conn=C3P0Util.getConnection();
        try {
            qr.update(conn,sql,user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

    public String queryByUsername(User user) throws SQLException {
        String sql="select password from user where username=?";
        System.out.println(user.getUsername());
        Connection connection = C3P0Util.getConnection();
        try {
            return qr.query(connection,sql,new ScalarHandler<String>(),user.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return null;
    }
}
