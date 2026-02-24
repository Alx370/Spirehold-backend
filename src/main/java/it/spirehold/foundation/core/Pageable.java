package com.waveinformatica.hello.foundation.core;

import io.quarkus.panache.common.Page;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;

@Getter
@Setter
@ToString
public class Pageable {
    @QueryParam("page")
    @DefaultValue("0")
    @PositiveOrZero
    private int page;

    @QueryParam("size")
    @DefaultValue("50")
    @Positive
    private int size;

    public Page toPage() {
        return Page.of(page, size);
    }
}
