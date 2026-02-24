package com.waveinformatica.hello.foundation.exceptions;

public class BadRequestException extends WebException {

    public BadRequestException() {
        super(400, null);
    }

    public BadRequestException(String message) {
        super(400, message);
    }
}
