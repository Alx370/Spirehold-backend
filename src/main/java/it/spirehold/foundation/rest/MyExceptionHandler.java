package com.waveinformatica.hello.foundation.rest;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import com.waveinformatica.hello.foundation.exceptions.WebException;

@Provider
public class MyExceptionHandler implements ExceptionMapper<WebException> {

    @Override
    public Response toResponse(WebException e) {
        return Response.status(e.getCode(), e.getMessage())
            .entity(new ErrorMessage(e.getCode(), e.getMessage()))
            .build();
    }
}
