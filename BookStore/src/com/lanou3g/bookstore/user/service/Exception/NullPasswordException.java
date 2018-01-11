package com.lanou3g.bookstore.user.service.Exception;

public class NullPasswordException extends UserException{
    @Override
    public String getMessage() {
        return "密码不能为空";
    }
}
