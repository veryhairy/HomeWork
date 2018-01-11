package com.lanou3g.bookstore.user.service.Exception;

public class OrderWrongException extends Exception{
    @Override
    public String getMessage() {
        return "订单异常";
    }
}
