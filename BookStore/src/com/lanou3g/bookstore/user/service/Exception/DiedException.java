package com.lanou3g.bookstore.user.service.Exception;

public class DiedException extends UserException{
    @Override
    public String getMessage() {
        return "未激活";
    }
}
