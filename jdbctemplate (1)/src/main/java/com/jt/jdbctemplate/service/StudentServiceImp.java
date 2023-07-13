package com.jt.jdbctemplate.service;

import com.jt.jdbctemplate.dao.StudentDao;
import com.jt.jdbctemplate.dto.request.CreateStudentRequest;
import com.jt.jdbctemplate.dto.request.UpdateStudentRequest;
import com.jt.jdbctemplate.dto.response.StudentResponse;
import com.jt.jdbctemplate.mapper.StudentMapper;
import com.jt.jdbctemplate.pojo.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService{

    private final StudentDao studentDao;
    private final StudentMapper studentMapper;

    @Override
    public Student add(CreateStudentRequest createStudentRequest) {
        log.debug("<<<<<<<<< add()");
        Student student=this.studentMapper.toStudent(createStudentRequest);
        log.debug("add() >>>>>>>");
        return  this.studentDao.saveStudent(student);
    }

    @Override
    public StudentResponse fetchStudentById(Integer id) {

        return  this.studentDao.findStudentById(id);

    }

    @Override
    public List<StudentResponse> getAllStudent() {
        return this.studentDao.getAllStudent();

    }

    @Override
    public String updateStudent(Integer id, UpdateStudentRequest updateStudentRequest) {
        Student student = this.studentMapper.updateRequestToStudent(updateStudentRequest);
        String result = this.studentDao.updateStudent(id, student);
         return result;
    }

    @Override
    public String deleteStudent(Integer id) {
      return  this.studentDao.deleteStudentById(id);
    }
}
