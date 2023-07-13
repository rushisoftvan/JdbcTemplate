package com.jt.jdbctemplate.dao;

import com.jt.jdbctemplate.dto.response.StudentResponse;
import com.jt.jdbctemplate.pojo.Student;

import java.util.List;

public interface StudentDao {

    Student saveStudent(Student student);
    void findStudentbyId(Integer id);

    StudentResponse findStudentById(Integer id);

    String updateStudent(Integer id, Student student);

    String deleteStudentById(Integer id);

    List<StudentResponse> getAllStudent();

}
