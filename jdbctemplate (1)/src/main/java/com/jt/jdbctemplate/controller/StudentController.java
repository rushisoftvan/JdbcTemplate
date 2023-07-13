package com.jt.jdbctemplate.controller;

import com.jt.jdbctemplate.dto.request.CreateStudentRequest;
import com.jt.jdbctemplate.dto.request.UpdateStudentRequest;
import com.jt.jdbctemplate.dto.response.ApiResponse;
import com.jt.jdbctemplate.dto.response.StudentResponse;
import com.jt.jdbctemplate.pojo.Student;
import com.jt.jdbctemplate.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/jdbcapi")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/students")
    public ApiResponse<Student> addStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        log.info("<<<<<<<<< addStudent()");
        Student addedStudent = this.studentService.add(createStudentRequest);
        log.info("addStudent() >>>>>>>");
        ApiResponse.ApiResponseBuilder<Student> builder = ApiResponse.builder();
        return builder.data(addedStudent).statusCode(HttpStatus.CREATED.value()).build();
    }

    @GetMapping("/students/{id}")
    public ApiResponse<StudentResponse> getStudentById(@PathVariable("id") @Positive(message = "id should be greter then zero") @NotNull(message = "id should not be null") Integer id){
        log.debug("<<<<<<<<< getStudentById()");
        StudentResponse studentResponse = this.studentService.fetchStudentById(id);
        log.debug("getStudentById() >>>>>>>");
        ApiResponse.ApiResponseBuilder<StudentResponse> builder = ApiResponse.builder();
        return builder.data(studentResponse).statusCode(HttpStatus.OK.value()).build();
    }
    
    @GetMapping("/students")
    public ApiResponse<List<StudentResponse>> getAllStudent()
    {      log.info("<<<<<<<<< getAllStudent()");
        List<StudentResponse> allStudent = this.studentService.getAllStudent();
        log.info("getAllStudent() >>>>>>>");
        ApiResponse.ApiResponseBuilder<List<StudentResponse>> builder = ApiResponse.builder() ;
        return  builder.data(allStudent).statusCode(HttpStatus.OK.value()).build();
    }

    @PutMapping("/students/{id}")
    public ApiResponse<String> updateStudent(@PathVariable("id") @Positive(message = "id should be greter then zero") @NotNull(message = "id should not be null") Integer id,@Valid @RequestBody UpdateStudentRequest updateStudentRequest){
        log.info("<<<<<<<<< updateStudent()");
        String result = this.studentService.updateStudent(id, updateStudentRequest);
        log.info("updateStudent() >>>>>>>");
        ApiResponse.ApiResponseBuilder<String> builder = ApiResponse.builder() ;
        return  builder.data(result).statusCode(HttpStatus.OK.value()).build();
    }

    @DeleteMapping("/students/{id}")
    public ApiResponse<String> deleteStuddentById(@PathVariable("id")  @Positive(message = "id should be greter then zero") @NotNull(message = "id should not be null")   Integer id){
        log.info("<<<<<<<<< deleteStuddentById()");
        String result = this.studentService.deleteStudent(id);
        log.info("deleteStuddentById() >>>>>>>");
        ApiResponse.ApiResponseBuilder<String> builder = ApiResponse.builder() ;
        return  builder.data(result).statusCode(HttpStatus.OK.value()).build();
    }
}
