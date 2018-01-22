package com.lanou3g.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by fwj on 2018/1/20.
 */
public class LoginInterceptor extends MethodFilterInterceptor{

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        Object attribute = session.getAttribute("username");
        if (attribute == null){
            return "login";
        }
        return actionInvocation.invoke();
    }
}
