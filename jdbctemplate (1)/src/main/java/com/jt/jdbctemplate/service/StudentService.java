package com.jt.jdbctemplate.service;

import com.jt.jdbctemplate.dto.request.CreateStudentRequest;
import com.jt.jdbctemplate.dto.request.UpdateStudentRequest;
import com.jt.jdbctemplate.dto.response.StudentResponse;
import com.jt.jdbctemplate.pojo.Student;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StudentService {

     Student add(CreateStudentRequest createStudentRequest);

    StudentResponse fetchStudentById(Integer id);

    List<StudentResponse> getAllStudent();

    String updateStudent(@PathVariable Integer id, UpdateStudentRequest updateStudentRequest);

    String deleteStudent(Integer id);


}
