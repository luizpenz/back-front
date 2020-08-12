package com.backend.api.core.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

@Getter
@Setter
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ErrorModelResponse {

    private Integer status;
    private String title;
    @Singular
    private List<ErrorModelDetailResponse> details;
}
