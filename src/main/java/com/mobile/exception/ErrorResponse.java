package com.mobile.exception;
/**
 * ErrorResponse
 *
 * @author shobha
 * @version 1.0
 */
public class ErrorResponse {
    private String[] errors;
    private String message;

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
