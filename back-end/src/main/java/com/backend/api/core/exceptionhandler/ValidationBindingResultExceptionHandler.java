package com.backend.api.core.exceptionhandler;

import com.backend.api.core.response.ErrorModelDetailResponse;
import com.backend.api.core.response.ErrorModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

@Component
public class ValidationBindingResultExceptionHandler {

    public ErrorModelResponse handleException(BindingResult bindingResult, HttpStatus status) {
        ErrorModelResponse error = ErrorModelResponse.builder()
                .status(status.value())
                .title("Invalid data")
                .details(bindingResult.getFieldErrors()
                        .stream()
                        .map(f -> {
                                return ErrorModelDetailResponse.builder()
                                        .field(f.getField())
                                        .message(f.getDefaultMessage())
                                        .build();
                        }).collect(Collectors.toList()))
                .build();

        return error;
    }
}
