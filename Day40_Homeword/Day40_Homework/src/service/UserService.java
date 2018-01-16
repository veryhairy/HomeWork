package service;

import dao.UserDao;

/**
 * Created by fwj on 2018/1/16.
 */
public class UserService {
    UserDao userDao = new UserDao();

    public void insert(String username,String password,int number,String email){
        userDao.insert(username,password,number,email);
    }

}
