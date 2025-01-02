package org.spring.s009springbootdemo.models;

public class ErrorDetail {
    private String message;

    public static ErrorDetail of(String message) {
        ErrorDetail error = new ErrorDetail();
        error.setMessage(message);
        return error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
