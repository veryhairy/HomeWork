package com.lanou3g.bookstore.order.dao;

import com.lanou.jdbc.JdbcUtils;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.domain.OrderItem;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {
    private QueryRunner qr = new QueryRunner();
    public void addOrder(Order order) {
        String sql = "insert into orders values(?,?,?,?,?,?)";
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            conn.setAutoCommit(false);
            qr.update(conn, sql, order.getOid(), order.getOrdertime(), order.getPrice(),
                      order.getState(), order.getUid(), order.getAddress());
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public void addOraerItem(List<OrderItem> orderItemList){
        String sql="insert into orderitem values(?,?,?,?,?)";
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
//            下面打包执行
            Object [][] params = new Object[orderItemList.size()][];
            for (int i = 0; i < params.length; i++) {
                params[i]=new Object[]{orderItemList.get(i).getIid(),
                        orderItemList.get(i).getCount(),
                        orderItemList.get(i).getSubtotal(),
                        orderItemList.get(i).getOid(),
                        orderItemList.get(i).getBid()};
            }
            qr.batch(conn,sql,params);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }

    public List<Order> findByUid(String uid) {
        String sql="select * from orders where uid=?";
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            return qr.query(conn,sql,new BeanListHandler<Order>(Order.class),uid);
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

    public List<OrderItem> findByOid(String oid) {
        String sql="select * from orderitem where oid=?";
        Connection conn=null;
        try {
            conn=JdbcUtils.getConnection();
            return qr.query(conn,sql,new BeanListHandler<OrderItem>(OrderItem.class),oid);
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

    public Book findBook(String bid) {
        String sql="select * from book where bid=?";
        Connection conn=null;
        try {
            conn=JdbcUtils.getConnection();
            return qr.query(conn,sql,new BeanHandler<Book>(Book.class),bid);
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

    public Order queryOrderByOid(String oid) {
        String sql = "select * from orders where oid=?";
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            return qr.query(conn,sql,new BeanHandler<Order>(Order.class),oid);
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

    public String getStateByOid(String oid) {
        String sql="select state from orders where oid=?";
        Connection conn=null;
        try {
            conn=JdbcUtils.getConnection();
            Integer query = qr.query(conn, sql, new ScalarHandler<Integer>(), oid);
            return query+"";

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

    public void updataState(String oid, int state) {
        String sql="update orders set state=? where oid=?";
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
            qr.update(conn,sql,state,oid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
