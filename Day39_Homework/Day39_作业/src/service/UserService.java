package service;

import bean.User;
import dao.UserDao;
import exception.PasswordWrongException;

import java.sql.SQLException;

/**
 * Created by fwj on 2018/1/15.
 */
public class UserService {
    UserDao userDao = new UserDao();
    public void insert(User user) throws SQLException {
        userDao.insert(user);


    }

    public void login(User user) throws SQLException, PasswordWrongException {
        String pswFromDb = userDao.queryByUsername(user);
        if (user.getPassword().equals(pswFromDb)){
            return;
        }else {
            throw new PasswordWrongException();
        }

    }
}
