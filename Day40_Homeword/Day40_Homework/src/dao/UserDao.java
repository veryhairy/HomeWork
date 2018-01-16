package dao;

import org.apache.commons.dbutils.QueryRunner;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by fwj on 2018/1/16.
 */
public class UserDao {
    private QueryRunner qr = new QueryRunner();

        public void insert(String username,String password,int number,String email){
            Connection connection = C3P0Util.getConnection();
            String sql="insert into user values (?,?,?,?)";
            try {
                qr.update(connection,sql,username,password,number,email);
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
}
