package com.example.btvn3.dto.respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ApiResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> sussces(T data){
        return new ApiResponse<>(200, "Thành công", data);
    }

    public static <T> ApiResponse<T> sussces(String message, T data){
        return new ApiResponse<>(200, message, data);
    }

    public static <T> ApiResponse<T> created(T data){
        return new ApiResponse<>(201, "Tạo thành công", data);
    }

    public static <T> ApiResponse<T> error(int code, String message){
        return new ApiResponse<>(code, message);
    }
}
