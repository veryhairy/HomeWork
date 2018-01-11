package com.lanou3g.bookstore.user.service.Exception;

public class DuplicateUsernameException  extends UserException {
    @Override
    public String getMessage() {
        return "用户名已存在";
    }
}
