package com.rajmi.notification;

import com.rajmi.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toStudentId(notificationRequest.toStudentId())
                        .sender("Rajmi")
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
