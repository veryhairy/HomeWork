package com.lanou3g.bookstore.user.service.Exception;

public class EmailDuplicateException extends UserException{
    @Override
    public String getMessage() {
        return "邮箱已注册";
    }
}
