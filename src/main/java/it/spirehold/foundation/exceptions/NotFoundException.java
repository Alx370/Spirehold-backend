package com.waveinformatica.hello.foundation.exceptions;

public class NotFoundException extends WebException {
    public NotFoundException() {
        super(404, null);
    }

    public NotFoundException(String message) {
        super(404, message);
    }

}
