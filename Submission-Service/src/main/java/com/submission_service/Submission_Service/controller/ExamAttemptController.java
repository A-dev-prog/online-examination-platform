package com.submission_service.Submission_Service.controller;

import com.submission_service.Submission_Service.dto.request.StartExamRequest;
import com.submission_service.Submission_Service.dto.request.SubmitExamRequest;
import com.submission_service.Submission_Service.dto.response.AttemptResponse;
import com.submission_service.Submission_Service.dto.response.StartExamResponse;
import com.submission_service.Submission_Service.dto.response.SubmitExamResponse;
import com.submission_service.Submission_Service.service.impl.ExamAttemptServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attempts")
@RequiredArgsConstructor
public class ExamAttemptController {

    private final ExamAttemptServiceImpl examAttemptService;

    @PostMapping("/start")
    public ResponseEntity<StartExamResponse> startExam(@Valid  @RequestBody StartExamRequest request) {

        return ResponseEntity.ok(examAttemptService.startExam(request));
    }

    @PostMapping("/{attemptId}/submit")
    public ResponseEntity<SubmitExamResponse> submitExam(@Valid @PathVariable Long attemptId, @RequestBody SubmitExamRequest request) {

        return ResponseEntity.ok(examAttemptService.submitExam(attemptId, request));
    }

    @GetMapping("/{attemptId}")
    public ResponseEntity<AttemptResponse> getAttempt(@Valid @PathVariable Long attemptId) {

        return ResponseEntity.ok(examAttemptService.getAttempt(attemptId));
    }
}
