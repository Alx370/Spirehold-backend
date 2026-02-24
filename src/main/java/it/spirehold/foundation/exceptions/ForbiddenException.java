package com.waveinformatica.hello.foundation.exceptions;

public class ForbiddenException extends WebException {
    public ForbiddenException() {
        super(403, null);
    }

    public ForbiddenException(String message) {
        super(403, message);
    }
}
