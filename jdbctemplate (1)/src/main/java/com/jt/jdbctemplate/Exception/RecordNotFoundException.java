package com.jt.jdbctemplate.Exception;

public class RecordNotFoundException extends  RuntimeException {
    public RecordNotFoundException(String msg){
        super(msg);
    }

}
