package com.lanou3g.bookstore.user.web.servlet;

import com.lanou3g.bookstore.book.domain.CartItem;
import com.lanou3g.bookstore.book.web.servlet.CartServlet;
import com.lanou3g.bookstore.user.dao.UserDao;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.Email;
import com.lanou3g.bookstore.user.service.Exception.UserException;
import com.lanou3g.bookstore.user.service.Exception.NoUsernameException;
import com.lanou3g.bookstore.user.service.Exception.VerificationFailedException;
import com.lanou3g.bookstore.user.service.UserService;
import com.lanou3g.bookstore.user.util.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
    private User formU = new User();
    private UserDao userDao = new UserDao();
    private UserService userService = new UserService();
    private String uuid=null;
    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Email sender = new Email();
        Map<String, String[]> parameterMap = request.getParameterMap();
        try {
            BeanUtils.populate(formU,parameterMap);
            String email = formU.getEmail();
            try {
                userService.registerCheck(formU);
            } catch (UserException e) {
                request.setAttribute("error",e.getMessage());
                return "f:/jsps/user/regist.jsp";
            }
            try {
                userService.check(formU);
                String uid = userService.get8UUID();
                uuid = userService.get12UUID();
                userDao.insert(formU,uid,uuid);
                sender.t1(email,uuid);
                request.setAttribute("msg","邮件发送成功，请去邮箱激活");
                return "f:/jsps/msg.jsp";
            } catch (UserException userException) {
                String message = userException.getMessage();
                request.setAttribute("error",message);
                return "f:/jsps/user/regist.jsp";
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String active(HttpServletRequest request,HttpServletResponse response){
        String code = request.getParameter("code");
        try {
            String active = userService.active(code,uuid);
            userDao.changeStatus(code);
            request.setAttribute("msg","验证成功,请登录");
            return active;
        } catch (VerificationFailedException e) {
            request.setAttribute("msg",e.getMessage());
        }
        return "f:/jsps/msg.jsp";
    }

    public String login(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        BeanUtils.populate(formU,parameterMap);
        try {
            request.getSession().setAttribute("username",formU.getUsername());
            request.getSession().setAttribute("user",formU);
            userService.login(formU);
            String uid = userService.getUid(formU.getUsername());
            request.getSession().setAttribute("uid",uid);
            Map<String,CartItem> map = new HashMap<>();
            request.getSession().setAttribute("map",map);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UserException e) {
            request.setAttribute("lgmeg",e.getMessage());
            return "f:/jsps/user/login.jsp";
        }
        return "r:index.jsp";
    }

    public String quit(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("username");
        return "r:/jsps/user/login.jsp";

    }


}


