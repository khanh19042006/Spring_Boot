    package com.example.btvn3.exception;

    public class DuplicateResourceException extends AppException{
        public DuplicateResourceException (String resourceName, String fieldName, Object findValue){
            super(409, String.format("%s đã tồn tại với %s: '%s'", resourceName, fieldName, findValue));
        }
    }
