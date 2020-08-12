package com.backend.api.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ModelResponse<T> {

    private T data;
    private ErrorModelResponse error;

    public static <T> ModelResponse withData(T data) {
        ModelResponse modelResponse = new ModelResponse();
        modelResponse.setData(data);

        return modelResponse;
    }

    public static ModelResponse<Object> withError(ErrorModelResponse error) {
        ModelResponse<Object> modelResponse = new ModelResponse();
        modelResponse.setError(error);

        return modelResponse;
    }
}
