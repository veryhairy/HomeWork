package com.lanou3g.bookstore.user.service.Exception;

public class NoUsernameException extends UserException {
    @Override
    public String getMessage() {
        return "用户名不存在";
    }
}
