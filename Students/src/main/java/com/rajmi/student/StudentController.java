package com.rajmi.student;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.management.remote.SubjectDelegationPermission;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
//if it fails put requestmapping here
public class StudentController{


    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @GetMapping(value = "/students")
    public List<Student> requestStudents(){
        return studentRepository.findAll();
    }
    @RequestMapping("api/v1/students")
    @PostMapping
    public void registerStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest){
        log.info("new student reg {}",studentRegistrationRequest);
        studentService.registerStudent(studentRegistrationRequest);
    }
}
