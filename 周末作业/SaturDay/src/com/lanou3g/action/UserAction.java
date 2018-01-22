package com.lanou3g.action;

import com.lanou3g.bean.Employee;
import com.lanou3g.util.HibernateUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Criteria;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by fwj on 2018/1/19.
 */
public class UserAction extends ActionSupport{
    private String username;
    private Employee employee;

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String login(){
//        ActionContext.getContext().
//                getSession().put("username",username);
        ServletActionContext.getRequest().
                getSession().setAttribute("username",username);
        return SUCCESS;
    }

    public String query(){
        System.out.println(1111111111);
        HibernateUtil.handle(session -> {
            Criteria criteria = session.createCriteria(Employee.class);
            List<Employee> employees = criteria.list();
            ServletActionContext.getRequest().setAttribute("users",employees);
            return null;
        });
        return SUCCESS;
    }

    public String update(){
        HibernateUtil.handle(session -> {
            System.out.println(employee);
            int id = employee.getId();
            Employee employee = session.get(Employee.class, id);
            employee.setName(this.employee.getName());
            employee.setAge(this.employee.getAge());
            employee.setDepartment(this.employee.getDepartment());
            employee.setEntrytime(this.employee.getEntrytime());
            employee.setAddress(this.employee.getAddress());
            employee.setPhnumber(this.employee.getPhnumber());
            session.save(employee);
            return null;
        });
        System.out.println(1);
        return SUCCESS;
    }

    public String queryById(){
        int id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
        HibernateUtil.handle(session -> {
            Employee employee = session.get(Employee.class, id);
            ServletActionContext.getRequest().setAttribute("user",employee);
            return employee;
        });
        return SUCCESS;
    }

    public String add(){
        HibernateUtil.handle(session -> {
           session.save(employee);
           return null;
        });
        return SUCCESS;
    }

    @Test
    public void text(){
        HibernateUtil.handle(session -> {
            for (int i = 0; i < 20; i++) {
                Employee employee = new Employee(i,"栗子"+i,i,"哔哔哔","99.99","南京路"+i+"号",2545+i);
                session.save(employee);
            }
            return null;
        });

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
