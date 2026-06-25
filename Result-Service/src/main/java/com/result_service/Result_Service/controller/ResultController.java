package com.result_service.Result_Service.controller;

import com.result_service.Result_Service.dto.GenerateResultResponse;
import com.result_service.Result_Service.dto.ResultResponse;
import com.result_service.Result_Service.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @PostMapping("/generate/{attemptId}")
    @ResponseStatus(HttpStatus.CREATED)
    public GenerateResultResponse generateResult(@PathVariable Long attemptId) {

        return resultService.generateResult(attemptId);
    }

    @GetMapping("/{resultId}")
    public ResponseEntity<ResultResponse> getResult(@PathVariable Long resultId) {
        return ResponseEntity.ok(resultService.getResult(resultId));
    }

    @GetMapping("/student/{studentId}")
    public List<ResultResponse> getResultsByStudent(@PathVariable Long studentId) {
        return resultService.getResultsByStudent(studentId);
    }
}
