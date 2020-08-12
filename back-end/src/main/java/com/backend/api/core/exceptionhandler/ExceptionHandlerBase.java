package com.backend.api.core.exceptionhandler;

import com.backend.api.core.response.ErrorModelResponse;
import org.springframework.http.HttpStatus;

public interface ExceptionHandlerBase<T> {

    ErrorModelResponse handleException(T ex, HttpStatus status);
}
