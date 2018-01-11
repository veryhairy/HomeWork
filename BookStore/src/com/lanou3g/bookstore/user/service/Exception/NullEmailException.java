package com.lanou3g.bookstore.user.service.Exception;

public class NullEmailException extends UserException{
    @Override
    public String getMessage() {
        return "邮箱不能为空";
    }
}
