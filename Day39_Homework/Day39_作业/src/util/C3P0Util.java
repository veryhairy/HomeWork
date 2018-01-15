package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by travelround on 17/4/18.
 */
public class C3P0Util {


    // 得到一个数据源(连接池)
    private static DataSource dataSource = new ComboPooledDataSource();

//    获得连接
    public static Connection getConnection() {
        try {
//            返回获得的连接
            return dataSource.getConnection();
        } catch (SQLException e) {
//            出错则报运行时错误：服务器忙
            throw new RuntimeException("服务器忙...");
        }
    }

//    关闭资源，接收三个参数，有谁未关闭就关闭谁
    public static void release(ResultSet resultSet, Statement stmt, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
//            若关闭失败，则将resultSet修改为null
            resultSet = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //            若关闭失败，则将stmt修改为null
            stmt = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //            若关闭失败，则将connection修改为null
            connection = null;
        }
    }

}
