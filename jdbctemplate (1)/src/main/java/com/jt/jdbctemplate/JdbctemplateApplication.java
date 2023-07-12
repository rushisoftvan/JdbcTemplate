package com.jt.jdbctemplate;

import com.jt.jdbctemplate.dao.StudentDao;
import com.jt.jdbctemplate.pojo.StudentPojo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class JdbctemplateApplication  implements CommandLineRunner {
   private final StudentDao studentDao;
	public static void main(String[] args) {
		SpringApplication.run(JdbctemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//for save operation
//		StudentPojo student = new StudentPojo("dpk", 23);
//        this.studentDao.saveStudent(student);
        //this.studentDao.findStudentbyId(1);


		//get data by In Student object by using row mapper

		StudentPojo studentById = this.studentDao.findStudentById(50);
		System.out.println(studentById);

	}
}
