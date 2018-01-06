package com.lanou3g.service;

import com.lanou3g.dao.BookDao;
import com.lanou3g.dao.UserDao;
import com.lanou3g.domain.Book;
import com.lanou3g.domain.User;
import com.lanou3g.service.exception.InvalidUsernameException;
import com.lanou3g.service.exception.LoginException;
import com.lanou3g.service.exception.PasswordNotMatchedException;

public class UserService {
    private UserDao userDao = new UserDao();
    private BookDao bookDao = new BookDao();

    public void login(User user) throws LoginException {
        User fromDb = userDao.queryByUsername(user.getUsername());
        if (fromDb == null){
            throw new InvalidUsernameException();
        }
        if (!fromDb.getPassword().equals(user.getPassword())){
            throw new PasswordNotMatchedException();
        }
    }
    public void register(User user){
        if (user.getUsername() !=null||user.getPassword() !=null){
            userDao.insertUser(user);
        }

    }

}
