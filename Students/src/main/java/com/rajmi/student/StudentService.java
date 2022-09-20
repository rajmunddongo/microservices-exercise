package com.rajmi.student;

import org.springframework.stereotype.Service;

@Service
public record StudentService(StudentRepository studentRepository) {
public void registerStudent(StudentRegistrationRequest studentRegistrationRequest){
    Student student=Student.builder()
            .name(studentRegistrationRequest.name())
            .university(studentRegistrationRequest.university())
            .teacher(studentRegistrationRequest.teacher())
            .build();
    studentRepository.save(student);
}
}
