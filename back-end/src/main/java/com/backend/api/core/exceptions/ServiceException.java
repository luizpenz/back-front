package com.backend.api.core.exceptions;

import java.util.Arrays;

public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Object... parameters) {
        super(String.format("%s : %s", message, Arrays.toString(parameters)));
    }
}
