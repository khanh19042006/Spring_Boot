package com.example.btvn3.exception;

public class BadRequestException extends AppException{
    public BadRequestException(String fieldName, Object findValue){
        super(400, String.format("Giá trị không hợp lệ cho %s: '%s'", fieldName, findValue));
    }
}
