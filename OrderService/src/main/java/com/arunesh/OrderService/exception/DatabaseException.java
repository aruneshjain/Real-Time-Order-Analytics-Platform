package com.arunesh.OrderService.exception;

import lombok.Getter;

@Getter
public class DatabaseException extends RuntimeException {
    private final String errorCode;

    public DatabaseException(String message) {
        super(message);
        this.errorCode = "DB_ERROR";
    }

    public DatabaseException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "DB_ERROR";
    }

    public DatabaseException(String message, String errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}


