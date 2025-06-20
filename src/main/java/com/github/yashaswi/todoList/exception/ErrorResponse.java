package com.github.yashaswi.todoList.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String message;
    private Integer status;
    private LocalDateTime timeStamp;

    public ErrorResponse(String message, Integer status){
        this.message = message;
        this.status = status;
        this.timeStamp = LocalDateTime.now();
    }

    // Add these getters
    public String getMessage() {
        return message;
    }

    public Integer getStatus() {
        return status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
