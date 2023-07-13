package com.jt.jdbctemplate;

import com.jt.jdbctemplate.dto.response.StudentResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<StudentResponse> {

               public static  RowMapper<StudentResponse> rowMapper = null;

    @Override
    public StudentResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(rs.getInt(1));
        studentResponse.setStudentName(rs.getString(2));
        studentResponse.setAge(rs.getInt(3));
        studentResponse.setStatus(rs.getBoolean(4));
        studentResponse.setCreatedOn(rs.getTimestamp(5).toLocalDateTime());
        studentResponse.setUpdatedOn(rs.getTimestamp(6).toLocalDateTime());
        return studentResponse;
    }

    public static RowMapper<StudentResponse>  getInstance(){
      if(rowMapper==null){
          rowMapper=new StudentRowMapper();
      }
      return rowMapper;
    }
}
