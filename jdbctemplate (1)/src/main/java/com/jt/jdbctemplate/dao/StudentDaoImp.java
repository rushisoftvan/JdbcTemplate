package com.jt.jdbctemplate.dao;

import com.jt.jdbctemplate.StudentRowMapper;
import com.jt.jdbctemplate.constants.AppConstants;
import com.jt.jdbctemplate.pojo.StudentPojo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class StudentDaoImp implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void saveStudent(StudentPojo student) {
        /*  update method can be used to perform insert,update,delete operation


         */
        int update = this.jdbcTemplate.update(AppConstants.STUDENT_INSERT_QUERY, student.getName(), student.getAge());
        log.info("data added :: {}", update);
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
    public StudentPojo findStudentById(Integer id) {
        /*
           we will use RowMapper here to convert the result set to row mapper
         */
        StudentPojo studentPojo = null;
        RowMapper<StudentPojo> studentRowMapper = new StudentRowMapper();
        try {
            studentPojo = this.jdbcTemplate.queryForObject(AppConstants.STUDENT_SELECT_ON, studentRowMapper, id);
            log.info("student id :: {}", studentPojo.getId());
            log.info("student name :: {}", studentPojo.getName());
            log.info("student age : {}", studentPojo.getAge());


        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMostSpecificCause());
        }
        return studentPojo;
    }


}
