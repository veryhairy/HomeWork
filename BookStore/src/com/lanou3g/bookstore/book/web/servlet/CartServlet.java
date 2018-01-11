package com.lanou3g.bookstore.book.web.servlet;

import com.lanou3g.bookstore.book.dao.BookDao;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.domain.CartItem;
import com.lanou3g.bookstore.user.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@WebServlet(name = "CartServlet",urlPatterns = "/cart")

public class CartServlet extends BaseServlet{
    BookDao bookDao = new BookDao();
    public String add(HttpServletRequest request, HttpServletResponse response){
        Map<String,CartItem> item = (Map<String, CartItem>) request.getSession().getAttribute("map");
        String bid = request.getParameter("bid");
        String count = request.getParameter("count");
        Book book = bookDao.queryByBid(bid);
        CartItem cartItem = new CartItem(count,book);
        item.put(book.getBid(),cartItem);
        request.getSession().setAttribute("item",item);
        return "f:/jsps/cart/list.jsp";
    }
    public String clear(HttpServletRequest request,HttpServletResponse response){
        Map item = (Map) request.getSession().getAttribute("item");
        item.clear();
        return "f:/jsps/cart/list.jsp";
    }

    public String delete(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        System.out.println(bid);
        Map item = (Map) request.getSession().getAttribute("item");
        item.remove(bid);
        return "f:/jsps/cart/list.jsp";
    }
}
