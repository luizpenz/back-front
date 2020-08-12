package com.backend.api.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ErrorModelDetailResponse {

    private String field;
    private Integer code;
    private String message;
    private String action;
}
