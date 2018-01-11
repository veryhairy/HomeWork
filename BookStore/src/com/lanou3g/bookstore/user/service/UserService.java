package com.lanou3g.bookstore.user.service;

import com.lanou.jdbc.JdbcUtils;
import com.lanou3g.bookstore.user.dao.UserDao;
import com.lanou3g.bookstore.user.domain.User;
import com.lanou3g.bookstore.user.service.Exception.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserService {

    private UserDao userDao = new UserDao();

    public void registerCheck(User form) throws UserException{
        String username = form.getUsername();
        String password = form.getPassword();
        String email = form.getEmail();
        if ("".equals(username)){
            throw new NullUsernameException();
        }
        if ("".equals(password)){
            throw new PasswordWrongException();
        }
        if ("".equals(email)){
            throw new NullEmailException();
        }
    }
    public void check(User fromDb) throws SQLException,UserException {
        ResultSet resultSet = userDao.queryByUsername(fromDb);
        ResultSet rs = userDao.queryByEmail(fromDb);
        boolean next1 = rs.next();
        boolean next = resultSet.next();
        if (next1){
            throw new EmailDuplicateException();
        }
        if (next){
            throw new DuplicateUsernameException();
        }
    }
    public  String get8UUID(){
        UUID id=UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0];
    }
    public  String get12UUID(){
        UUID id=UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0]+idd[1];
    }
    public String active(String code,String uuid) throws VerificationFailedException {
        if (code.equals(uuid)){
            return "f:/jsps/msg.jsp";
        }else {
            throw new VerificationFailedException();
        }
    }

    public void login(User form) throws UserException, SQLException{
        ResultSet resultSet = userDao.queryByUsername(form);
        boolean next = resultSet.next();
        if (!next){
                throw new NoUsernameException();
        }
        String password = null;
        String state = null;
        if (next){
            password = resultSet.getString("password");
            state = resultSet.getString("state");
            if (password == null){
                password = "";
            }
            if (state == null){
                state = "";
            }
        }
        if (!password.equals(form.getPassword())){
            throw new PasswordWrongException();
        }
        if (!state .equals("2")){
            throw new DiedException();
        }
    }

    public String getUid(String username) {
        QueryRunner qr = new QueryRunner();
        String sql = "select uid from user where username=?";
        Connection conn = null;
        try {
            conn=JdbcUtils.getConnection();
           return qr.query(conn, sql, new ScalarHandler<String>(), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
