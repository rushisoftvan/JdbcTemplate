package com.jt.jdbctemplate.dao;

import com.jt.jdbctemplate.pojo.StudentPojo;

public interface StudentDao {

    void saveStudent(StudentPojo student);
    void findStudentbyId(Integer id);

    StudentPojo findStudentById(Integer id);
}
