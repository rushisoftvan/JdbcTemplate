package com.jt.jdbctemplate;

import com.jt.jdbctemplate.pojo.StudentPojo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentPojo> {
    @Override
    public StudentPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setId(rs.getInt(1));
        studentPojo.setName(rs.getString(2));
        studentPojo.setAge(rs.getInt(3));
        return studentPojo;
    }
}
