package com.jt.jdbctemplate.constants;

public class AppConstants {

    public static final String STUDENT_INSERT_QUERY="insert into studenttest(name,age) values(?,?)";
    public static final String STUDENT_SELECT_ON="select id,name,age from studenttest where id= ?";

}
