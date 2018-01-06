package com.lanou3g.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        Class<? extends BaseServlet> servlet = this.getClass();
        Method method = null;
        try {
             method = servlet.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("no methodName");
        }
        try {
            String result = (String) method.invoke(this, req, resp);
            if (result == null){
                return;
            }
            String[] split = result.split(":");
            String type = split[0];
            String path = split[1];
            if (type.equals("f")){
//                请求转发
                req.getRequestDispatcher(path).forward(req,resp);
                System.out.println("转发完毕");
            }else if (type.equals("r")){
//                重定向
                resp.sendRedirect(req.getContextPath()+path);
                System.out.println("重定向完毕");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
