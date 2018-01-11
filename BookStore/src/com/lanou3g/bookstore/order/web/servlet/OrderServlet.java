package com.lanou3g.bookstore.order.web.servlet;

import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.domain.CartItem;
import com.lanou3g.bookstore.order.Service.OrderService;
import com.lanou3g.bookstore.order.dao.OrderDao;
import com.lanou3g.bookstore.order.domain.Order;
import com.lanou3g.bookstore.order.domain.OrderItem;
import com.lanou3g.bookstore.user.dao.UserDao;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.UserService;
import com.lanou3g.bookstore.user.util.BaseServlet;
import org.junit.Test;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet (name = "OrderServlet",urlPatterns = "/order")
public class OrderServlet extends BaseServlet{
    private OrderService orderService = new OrderService();
    private UserService userService = new UserService();
    private UserDao userDao = new UserDao();
    private OrderDao orderDao = new OrderDao();

    public String add(HttpServletRequest request,HttpServletResponse response){
        Map<String,CartItem> item = (Map<String, CartItem>) request.getSession().getAttribute("item");
        String price = request.getParameter("price");
        String subtotal1 = request.getParameter("subtotal1");
        String uid = (String) request.getSession().getAttribute("uid");
        String oid = userService.get8UUID();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Order order = new Order(oid,format,price,1,uid,"xxx");
        orderService.add(order);
        List<OrderItem> list = new ArrayList<>();

        for (String key : item.keySet()) {
            String iid = userService.get8UUID();
            String bid = item.get(key).getBook().getBid();
            double price1 = item.get(key).getBook().getPrice();
            String count = item.get(key).getCount();
            double v = Double.parseDouble(count);
            double subtotal = price1*v;
            OrderItem orderItem = new OrderItem(iid,v,subtotal,oid,bid);
            list.add(orderItem);
        }

            orderService.addOrderItem(list);
        request.setAttribute("order",order);
        request.setAttribute("item",item);
        request.setAttribute("subtotal",subtotal1);
        return "f:jsps/order/desc.jsp";
    }

    public String myOrders(HttpServletRequest request,HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");
        String username = user.getUsername();
        User uuser = userDao.queryUid(username);
        String uid = uuser.getUid();
        List<Order> all = orderService.getAll(uid);
        request.setAttribute("allItem",all);
        return "f:/jsps/order/list.jsp";
        }

    public String load(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        Order order = orderService.getOrderByOid(oid);
        request.setAttribute("order",order);
        return "f:/jsps/order/desc.jsp";
    }

    public String confirm(HttpServletRequest request,HttpServletResponse response){
        String oid = request.getParameter("oid");
        String msg = orderService.confirm(oid);
        request.setAttribute("msg",msg);
        return "f:/jsps/order/msg.jsp";
    }

    }

