package com.rajmi.fraud;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {

    private final FraudCheckService fraudCheckService;


    @GetMapping(path="{studentId}")
    public FraudCheckResponse isFraudster(@PathVariable("studentId") Integer studentId){
        boolean isFraudulentStudent = fraudCheckService.isFraudulentStudent(studentId);
        return new FraudCheckResponse(isFraudulentStudent);

    }
}
