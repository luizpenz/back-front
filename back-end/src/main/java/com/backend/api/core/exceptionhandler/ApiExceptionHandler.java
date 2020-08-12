package com.backend.api.core.exceptionhandler;

import com.backend.api.core.exceptions.ServiceException;
import com.backend.api.core.response.ErrorModelDetailResponse;
import com.backend.api.core.response.ErrorModelResponse;
import com.backend.api.core.response.ModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MethodArgumentNotValidExceptionHandler methodArgumentNotValidExceptionHandler;

    @Autowired
    private ValidationBindingResultExceptionHandler validationBindingResultExceptionHandler;

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorModelResponse errorModelResponse = (ErrorModelResponse) body;

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorModelResponse errorModelResponse = methodArgumentNotValidExceptionHandler.handleException(ex, status);

        return handleExceptionInternal(ex, errorModelResponse, headers, status, request);
    }

    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<Object> handleServiceException(ServiceException ex) {

        ErrorModelResponse error = ErrorModelResponse.builder()
                .status(HttpStatus.CONFLICT.value())
                .title("Internal server error")
                .detail(ErrorModelDetailResponse.builder()
                            .message(ex.getMessage())
                        .build())
                .build();

        return ResponseEntity.ok(ModelResponse.withError(error));
    }

}
