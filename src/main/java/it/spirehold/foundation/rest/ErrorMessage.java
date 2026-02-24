package com.waveinformatica.hello.foundation.rest;

import lombok.Getter;

@Getter
public class ErrorMessage {
    private final int status;
    private final String message;


    public ErrorMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

}
