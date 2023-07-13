package com.jt.jdbctemplate.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentResponse {
     private Integer studentId;
     private String studentName;

     private Integer age;

     private Boolean status;

     private LocalDateTime createdOn;

     private LocalDateTime updatedOn;
}
