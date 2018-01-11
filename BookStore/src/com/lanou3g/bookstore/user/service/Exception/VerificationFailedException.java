package com.lanou3g.bookstore.user.service.Exception;

public class VerificationFailedException extends UserException{
    @Override
    public String getMessage() {
        return "验证失败";
    }
}
