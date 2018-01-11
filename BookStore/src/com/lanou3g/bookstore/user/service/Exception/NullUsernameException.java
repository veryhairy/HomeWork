package com.lanou3g.bookstore.user.service.Exception;

public class NullUsernameException extends UserException {
    @Override
    public String getMessage() {
        return "用户名不能为空";
    }
}
