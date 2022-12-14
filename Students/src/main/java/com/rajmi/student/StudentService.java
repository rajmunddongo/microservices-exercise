package com.rajmi.student;

import com.rajmi.clients.fraud.FraudCheckResponse;
import com.rajmi.clients.fraud.FraudClient;
import com.rajmi.clients.notification.NotificationClient;
import com.rajmi.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class StudentService {

    private final NotificationClient notificationClient;
    private final StudentRepository studentRepository;
    private final FraudClient   fraudClient;


public void registerStudent(StudentRegistrationRequest studentRegistrationRequest){
    Student student=Student.builder()
            .name(studentRegistrationRequest.name())
            .university(studentRegistrationRequest.university())
            .teacher(studentRegistrationRequest.teacher())
            .build();
    studentRepository.saveAndFlush(student);


    FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(student.getId());
    if(fraudCheckResponse.isFraudster())
        try {
            throw new IllegalAccessException("Fraudster detected!");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    notificationClient.sendNotification(
            new NotificationRequest(
                    student.getId(),
                    student.getName(),
                    String.format("Hi %s, welcome to the classroom.",
                            student.getName())
            )
    );


}
}