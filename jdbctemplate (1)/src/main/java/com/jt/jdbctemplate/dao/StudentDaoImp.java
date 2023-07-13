package com.jt.jdbctemplate.dao;

import com.jt.jdbctemplate.Exception.CustomException;
import com.jt.jdbctemplate.Exception.RecordNotFoundException;
import com.jt.jdbctemplate.StudentRowMapper;
import com.jt.jdbctemplate.constants.AppConstants;
import com.jt.jdbctemplate.dto.response.StudentResponse;
import com.jt.jdbctemplate.pojo.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class StudentDaoImp implements StudentDao {

    public static final boolean DELETESTATUS = false;
    private final JdbcTemplate jdbcTemplate;
    //RowMapper<StudentResponse> studentRowMapper = new StudentRowMapper();
    @Override
    public Student saveStudent(Student student) {
        /*  update method can be used to perform insert,update,delete operation
         */
        student.setStatus(true);
        student.setCreatedOn(LocalDateTime.now());
        student.setUpdatedOn(LocalDateTime.now());
        int update = this.jdbcTemplate.update(AppConstants.STUDENT_INSERT_QUERY, student.getName(), student.getAge(),student.getStatus(),student.getCreatedOn(),student.getUpdatedOn());
        log.info("data added :: {}", update);
        if(update>0){
            return student;
        }
            throw new CustomException("Somthing is wrong");
    }
    @Override
    public void findStudentbyId(Integer id) {
        /*
           queryforObject method use for to fectching the data(String sql,RowMapper<T>,Object args)

           queryformap() : selects a single record.return map  which contains coulumn names as key and column values of record as value
         */
        Map<String, Object> stringObjectMap = this.jdbcTemplate.queryForMap(AppConstants.STUDENT_SELECT_ON, id);
        log.info("data : : {}", stringObjectMap); //output data : : {id=1, name=sachin, age=21}

    }

    @Override
    public StudentResponse findStudentById(Integer id) {
        /*
           we will use RowMapper here to convert the result set to row mapper
         */
        StudentResponse studentResponse = null;

        try {
            studentResponse =  this.jdbcTemplate.queryForObject(AppConstants.STUDENT_SELECT_ON, StudentRowMapper.getInstance(), id);
            log.info("student id :: {}", studentResponse.getStudentId());
            log.info("student name :: {}", studentResponse.getStudentName());
            log.info("student age : {}", studentResponse.getAge());
        } catch (EmptyResultDataAccessException e) {
            throw new RecordNotFoundException("Student is not available for thid id : "+ id );
        }
        return studentResponse;
    }

    @Override
    public String updateStudent(Integer id, Student student) {
        int update = this.jdbcTemplate.update(AppConstants.STUDENT_UPDATE, student.getName(), student.getAge(), student.getStatus(), student.getUpdatedOn(), id);
        if(update>0){
            return "Data is updated for id : " + id ;
        }
        throw new CustomException("somthing is wrong");

    }

    @Override
    public String deleteStudentById(Integer id) {
        int update = this.jdbcTemplate.update(AppConstants.STUDENT_DELETE, DELETESTATUS, id);
        if(update>0){
            return "Student is deleted for id : "+id;
        }
        throw new CustomException("somthing is wrong");
    }

    @Override
    public List<StudentResponse> getAllStudent() {

        List<StudentResponse> students = this.jdbcTemplate.query(AppConstants.STUDENT_SELECT_ALL, StudentRowMapper.getInstance());
       if(students.isEmpty()){
           throw new RecordNotFoundException("NO any Student available");
       }
       return students;
    }
}
