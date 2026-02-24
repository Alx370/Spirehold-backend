package com.waveinformatica.hello.foundation.exceptions;

public class UnauthorizedException extends WebException {

    public UnauthorizedException() {
        super(401, null);
    }

    public UnauthorizedException(String message) {
        super(401, message);
    }
}
