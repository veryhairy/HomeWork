package com.lanou3g.bookstore.order.Service;

import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.order.dao.OrderDao;
import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.domain.OrderItem;
import com.lanou3g.bookstore.user.service.Exception.OrderWrongException;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private OrderDao orderDao = new OrderDao();

    public void add(Order order) {
        orderDao.addOrder(order);
    }
    public void addOrderItem(List<OrderItem> list){
        orderDao.addOraerItem(list);

    }
    public List<Order> getAll(String uid) {
        List<Order> buUid = orderDao.findByUid(uid);
        for (int i = 0; i < buUid.size(); i++) {
            String oid = buUid.get(i).getOid();
            List<OrderItem> byOid = orderDao.findByOid(oid);
            buUid.get(i).setOrderItem(byOid);

            for (int j = 0; j < byOid.size(); j++) {
                String bid = byOid.get(j).getBid();
                Book book = orderDao.findBook(bid);
                byOid.get(j).setBook(book);
            }
        }
        return buUid;
    }
    public Order getOrderByOid(String oid){
        Order order = orderDao.queryOrderByOid(oid);
        List<OrderItem> byOid = orderDao.findByOid(oid);
        order.setOrderItem(byOid);
        for (int i = 0; i < byOid.size(); i++) {
            String bid = byOid.get(i).getBid();
            Book book = orderDao.findBook(bid);
            byOid.get(i).setBook(book);
        }
        return order;
    }

    public String confirm(String oid) {
        String stateByOid = orderDao.getStateByOid(oid);
        if (!stateByOid.equals("3")){
            try {
                throw new OrderWrongException();
            } catch (OrderWrongException e) {
                return e.getMessage();
            }
        }
            orderDao.updataState(oid,4);
        return "成功";
    }
}
