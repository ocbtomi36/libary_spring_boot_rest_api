package net.myapi.springboot.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime localDateTime;
    private String message;
    private String path;
    private String errorCode;

    public ErrorDetails(){}

    public ErrorDetails(LocalDateTime localDateTime, String message, String path, String errorCode) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
