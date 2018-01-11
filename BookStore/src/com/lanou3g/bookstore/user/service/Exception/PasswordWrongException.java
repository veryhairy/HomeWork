package com.lanou3g.bookstore.user.service.Exception;

public class PasswordWrongException extends UserException{
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
