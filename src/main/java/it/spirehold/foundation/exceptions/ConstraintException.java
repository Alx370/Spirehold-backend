package com.waveinformatica.hello.foundation.exceptions;

public class ConstraintException extends BadDataException {

    public ConstraintException() {
        super();
    }
    public ConstraintException(String message) {
        super(message);
    }
}
