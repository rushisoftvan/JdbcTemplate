package com.jt.jdbctemplate.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter

public class CreateStudentRequest {

    @NotEmpty
    private String studentName;

    @NotNull
    private Integer age;
}
