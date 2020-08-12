package com.backend.api.core.exceptionhandler;

import com.backend.api.core.response.ErrorModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Component
public class MethodArgumentNotValidExceptionHandler implements ExceptionHandlerBase<MethodArgumentNotValidException>{

    @Autowired
    private ValidationBindingResultExceptionHandler validationBindingResultExceptionHandler;

    @Override
    public ErrorModelResponse handleException(MethodArgumentNotValidException ex, HttpStatus status) {
        return validationBindingResultExceptionHandler.handleException(ex.getBindingResult(), status);
    }
}
