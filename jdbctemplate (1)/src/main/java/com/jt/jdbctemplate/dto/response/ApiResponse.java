package com.jt.jdbctemplate.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ApiResponse<T> {
    private T data;

    private Integer statusCode;

    private List<String> errors;
}
