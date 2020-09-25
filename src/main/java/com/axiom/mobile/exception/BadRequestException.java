package com.axiom.mobile.exception;

import java.util.List;

public class BadRequestException extends ApplicationBaseException {
    List<String> errors;
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(List<String> errorLst,String message) {
        super(message);
       this.errors=errorLst;
    }

    public List<String> getErrors() {
        return errors;
    }
}
