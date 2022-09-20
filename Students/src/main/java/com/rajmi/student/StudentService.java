package com.rajmi.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class StudentService {

    private final RestTemplate restTemplate;
    private final StudentRepository studentRepository;

<<<<<<< Updated upstream
public void registerStudent(StudentRegistrationRequest studentRegistrationRequest){
    Student student=Student.builder()
            .name(studentRegistrationRequest.name())
            .university(studentRegistrationRequest.university())
            .teacher(studentRegistrationRequest.teacher())
            .build();
    studentRepository.saveAndFlush(student);

    FraudCheckResponse fraudCheckResponse= restTemplate.getForObject(
            "http:localhost:8081/api/v1/fraud-check/{studentId}",
            FraudCheckResponse.class,
            student.getId()
    );
    if(fraudCheckResponse.isFraudster())
        try {
            throw new IllegalAccessException("Fraudster detected!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

}
}
=======
    public void registerStudent(StudentRegistrationRequest studentRegistrationRequest){
        Student student=Student.builder()
                .name(studentRegistrationRequest.name())
                .university(studentRegistrationRequest.university())
                .teacher(studentRegistrationRequest.teacher())
                .build();
        studentRepository.saveAndFlush(student);

        FraudCheckResponse fraudCheckResponse= restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{studentId}",
                FraudCheckResponse.class,
                student.getId()
        );

    }
}
>>>>>>> Stashed changes
