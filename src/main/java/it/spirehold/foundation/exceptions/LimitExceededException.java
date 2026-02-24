package com.waveinformatica.hello.foundation.exceptions;

public class LimitExceededException extends WebException {

    public LimitExceededException() {
        super(422, null);
    }

    public LimitExceededException(String message) {
        super(422, message);
    }
}
