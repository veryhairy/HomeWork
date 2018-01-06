package com.lanou3g.web;

import com.lanou3g.dao.BookDao;
import com.lanou3g.domain.Book;
import com.lanou3g.domain.User;
import com.lanou3g.service.UserService;
import com.lanou3g.service.exception.LoginException;
import com.lanou3g.util.BaseServlet;
import net.sf.json.JSONArray;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();
    private BookDao bookDao = new BookDao();
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Cookie cookie = new Cookie("username",username);
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);

        User formU = new User();
        formU.setUsername(username);
        formU.setPassword(password);
        try {
            userService.login(formU);
            request.getSession().setAttribute("username",username);
            return "r:index.jsp";
        } catch (LoginException e) {
            e.printStackTrace();
            return "f:login.jsp";
        }


    }

    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User u = new User();
        try {
            BeanUtils.populate(u,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.register(u);
        return "r:login.jsp";

    }

    public String book(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> parameterMap = request.getParameterMap();
        Book book = new Book();
        try {
            BeanUtils.populate(book,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        bookDao.insert(book);
        return "r:index.jsp";
    }

    public void showbooks(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Book> books = bookDao.queryAll();
        JSONArray jsonArray = JSONArray.fromObject(books);
        response.getWriter().write(jsonArray.toString());

    }

    public String exit(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        return "r:login.jsp";
    }
}
