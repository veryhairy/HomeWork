package com.lanou3g.bookstore.book.web.servlet;

import com.lanou3g.bookstore.book.dao.BookDao;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.domain.Category;
import com.lanou3g.bookstore.book.service.BookService;
import com.lanou3g.bookstore.user.util.BaseServlet;
import org.omg.CORBA.Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookServlet",urlPatterns = "/book")
public class BookServlet extends BaseServlet {
    BookDao bookDao = new BookDao();
    private BookService bookService = new BookService();


    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Book> allBook = bookService.pull();
        request.setAttribute("allBook",allBook);
        return "f:/jsps/book/list.jsp";
    }

    public String findByCategory(HttpServletRequest request,HttpServletResponse response){
        String cid = request.getParameter("cid");
        List<Book> foundCid = bookService.findCid(cid);
        request.setAttribute("foundCid",foundCid);
        return "f:/jsps/book/list.jsp";
    }

    public String load(HttpServletRequest request,HttpServletResponse response){
        String bid = request.getParameter("bid");
        Book book = bookDao.queryByBid(bid);
        request.setAttribute("book",book);
        return"f:/jsps/book/desc.jsp";
    }

    public String left(HttpServletRequest request,HttpServletResponse response) throws SQLException {
        List<Category> categories = bookDao.queryAllCategory();
        request.setAttribute("left",categories);
        return "f:/jsps/left.jsp";
    }
}
