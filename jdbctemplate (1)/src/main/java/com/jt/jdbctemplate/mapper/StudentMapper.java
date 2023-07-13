package com.jt.jdbctemplate.mapper;

import com.jt.jdbctemplate.dto.request.CreateStudentRequest;
import com.jt.jdbctemplate.dto.request.UpdateStudentRequest;
import com.jt.jdbctemplate.pojo.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StudentMapper {

     public  Student toStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student();
        student.setName(createStudentRequest.getStudentName());
        student.setAge(createStudentRequest.getAge());
        return  student;
    }
    
    public Student updateRequestToStudent(UpdateStudentRequest updateStudentRequest){
        Student student = new Student();
        student.setName(updateStudentRequest.getName());
        student.setAge(updateStudentRequest.getAge());
        student.setStatus(updateStudentRequest.getStatus());
        student.setUpdatedOn(LocalDateTime.now());
        return student;
    }
    



}
