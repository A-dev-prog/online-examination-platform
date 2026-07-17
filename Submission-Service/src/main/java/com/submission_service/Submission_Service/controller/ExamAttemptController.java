package com.submission_service.Submission_Service.controller;

import com.submission_service.Submission_Service.dto.internal.AttemptDetailResponse;
import com.submission_service.Submission_Service.dto.request.StartExamRequest;
import com.submission_service.Submission_Service.dto.request.SubmitExamRequest;
import com.submission_service.Submission_Service.dto.response.AttemptResponse;
import com.submission_service.Submission_Service.dto.response.StartExamResponse;
import com.submission_service.Submission_Service.dto.response.SubmitExamResponse;
import com.submission_service.Submission_Service.service.ExamAttemptService;
import com.submission_service.Submission_Service.service.impl.ExamAttemptServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(
        name = "Exam Attempt APIs",
        description = "Start and submit exam attempts"
)
@RestController
@RequestMapping("/api/attempts")
@RequiredArgsConstructor
public class ExamAttemptController {

    private final ExamAttemptServiceImpl examAttemptService;
    @Operation(
            summary = "Start Exam",
            description = "Creates a new exam attempt for a student."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Exam started successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Exam not found")
    })
    @PostMapping("/start")
    public ResponseEntity<StartExamResponse> startExam(@Valid  @RequestBody StartExamRequest request) {

        return ResponseEntity.ok(examAttemptService.startExam(request));
    }
    @Operation(
            summary = "Submit Exam",
            description = "Submits the student's answers for an exam attempt."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Exam submitted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Attempt not found")
    })
    @PostMapping("/{attemptId}/submit")
    public ResponseEntity<SubmitExamResponse> submitExam(@Valid @PathVariable Long attemptId, @RequestBody SubmitExamRequest request) {

        return ResponseEntity.ok(examAttemptService.submitExam(attemptId, request));
    }
    @Operation(
            summary = "Get Exam Attempt",
            description = "Returns details of a specific exam attempt."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Attempt found"),
            @ApiResponse(responseCode = "404", description = "Attempt not found")
    })
    @GetMapping("/{attemptId}")
    public ResponseEntity<AttemptResponse> getAttempt(@Valid @PathVariable Long attemptId) {

        return ResponseEntity.ok(examAttemptService.getAttempt(attemptId));
    }
    @Operation(
            summary = "Internal Attempt Details",
            description = "Returns attempt details for Result Service. Internal API only."
    )
    @GetMapping("/internal/{attemptId}")
    public AttemptDetailResponse getAttemptDetails(
            @PathVariable Long attemptId
    ) {
        return examAttemptService.getAttemptDetails(attemptId);
    }
}
