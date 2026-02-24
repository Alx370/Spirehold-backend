package com.waveinformatica.hello.foundation.exceptions;

import lombok.Getter;

public class WebException extends RuntimeException {

    @Getter
    private int code;

    public WebException() {
        this(500, null);
    }

    public WebException(String message) {
        this(500, message);
    }

    public WebException(int code, String message) {
        super(message);
        this.code = code;
    }
}
