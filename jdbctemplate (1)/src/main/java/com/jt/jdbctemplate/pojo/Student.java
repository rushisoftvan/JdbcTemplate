package com.jt.jdbctemplate.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jt.jdbctemplate.enums.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class Student {
   @JsonIgnore
   private Integer id;


   private String name;

   private Integer age;


   private Boolean status;

   private LocalDateTime createdOn;

   private LocalDateTime updatedOn;

   }


