package com.jt.jdbctemplate.constants;

public class AppConstants {

    public static final String STUDENT_INSERT_QUERY="insert into studenttest(name,age,status,created_on,updated_on) values(?,?,?,?,?)";
    public static final String STUDENT_SELECT_ON="select * from studenttest where id= ?";

    public static final String STUDENT_SELECT_ALL="select * from studenttest";

    public  static final String STUDENT_UPDATE="UPDATE studenttest SET name = ?, age = ?,status=?, updated_on = ? WHERE id = ?";

    public static final String STUDENT_DELETE="UPDATE studenttest set status=? where id=?";

}
