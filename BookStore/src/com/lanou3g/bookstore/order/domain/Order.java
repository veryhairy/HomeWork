package com.lanou3g.bookstore.order.domain;


import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.domain.CartItem;

import java.lang.ref.SoftReference;
import java.util.List;
import java.util.Map;

public class Order {
    private String oid;
    private String ordertime;
    private String price;
    private int state;
    private String uid;
    private String address;
    private List<OrderItem> orderItem;
//        TODO OrderItem 应该是list
//    book装在OrderItem里面

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", price='" + price + '\'' +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Order(String oid, String ordertime, String price, int state, String uid, String address) {
        this.oid = oid;
        this.ordertime = ordertime;
        this.price = price;
        this.state = state;
        this.uid = uid;
        this.address = address;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order() {

    }
}
