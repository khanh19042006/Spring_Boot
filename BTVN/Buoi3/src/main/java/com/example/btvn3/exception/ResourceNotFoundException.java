package com.example.btvn3.exception;

public class ResourceNotFoundException extends AppException {
    public ResourceNotFoundException(String resourceName, String fieldName, Object findValue) {
        super(404, String.format("%s không tìm thấy với %s: '%s'", resourceName, fieldName, findValue));
    }
}