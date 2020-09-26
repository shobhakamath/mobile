package com.mobile.exception;

import java.util.List;
/**
 * BadRequestException
 *
 * @author shobha
 * @version 1.0
 */
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
