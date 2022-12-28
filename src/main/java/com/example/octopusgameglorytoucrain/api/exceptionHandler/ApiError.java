package com.example.octopusgameglorytoucrain.api.exceptionHandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.singletonList;

@Getter
public class ApiError {
    private final HttpStatus status;
    private final String message;

    private LocalDate timestamp;
    private final List<String> errors;

    public ApiError(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = List.copyOf(errors);
        timestamp = LocalDate.now();
    }

    public ApiError(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        this.errors = singletonList(error);
        timestamp = LocalDate.now();
    }
}
