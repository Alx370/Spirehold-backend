package com.waveinformatica.hello.foundation.exceptions;

public class BadDataException extends BadRequestException {
    public BadDataException() {
    }

    public BadDataException(String message) {
        super(message);
    }
}
