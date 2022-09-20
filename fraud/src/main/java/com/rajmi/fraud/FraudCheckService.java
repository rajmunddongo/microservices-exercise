package com.rajmi.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;


    public boolean isFraudulentStudent(Integer studentId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                .studentId(studentId)
                .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                .build()
        );
        return false;
    }
}
