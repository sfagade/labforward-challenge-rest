package com.app.labforward.challenge.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomValidationException extends RuntimeException {

    private final boolean error = true;
    private int errorCode;

    public CustomValidationException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
