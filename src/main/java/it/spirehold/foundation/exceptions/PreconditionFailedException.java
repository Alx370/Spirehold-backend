package com.waveinformatica.hello.foundation.exceptions;

public class PreconditionFailedException extends WebException {

    public PreconditionFailedException() {
        super(412, null);
    }

    public PreconditionFailedException(String message) {
        super(412, message);
    }

}
