package com.jt.jdbctemplate.dto.request;

import com.jt.jdbctemplate.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateStudentRequest {

    @NotEmpty(message="name should not be null or empty")
    private String name;

    @NotNull(message="age should not be null")
    private Integer age;

    @NotNull(message="status should not be null")
    private Boolean status;
}
