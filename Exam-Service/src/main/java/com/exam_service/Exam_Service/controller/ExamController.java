package com.exam_service.Exam_Service.controller;

import com.exam_service.Exam_Service.dto.internal.ExamAnswerKeyResponse;
import com.exam_service.Exam_Service.dto.request.CreateExamRequest;
import com.exam_service.Exam_Service.dto.request.CreateQuestionRequest;
import com.exam_service.Exam_Service.dto.response.*;
import com.exam_service.Exam_Service.repository.QuestionRepository;
import com.exam_service.Exam_Service.service.impl.ExamServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Exam APIs",
        description = "APIs for managing online examinations"
)
@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamServiceImpl  examService;
    private final QuestionRepository questionRepository;
    @Operation(
            summary = "Create Exam",
            description = "Creates a new exam with questions and answer options."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Exam created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "404", description = "Resource not found")
    })
    @PostMapping
    public ResponseEntity<CreateExamResponse> createExam(@RequestBody CreateExamRequest request)
    {
        return ResponseEntity.ok(examService.createExam(request));
    }
    @Operation(
            summary = "Get Exam By ID",
            description = "Retrieves complete exam details."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Exam found"),
            @ApiResponse(responseCode = "404", description = "Exam not found")
    })
    @PostMapping("/{examId}/questions")
    public ResponseEntity<QuestionResponse> addQuestion(
            @PathVariable Long examId,
            @Valid @RequestBody CreateQuestionRequest request
    ) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(examService.addQuestion(examId, request));
    }
    @GetMapping("/{examId}")
    public ResponseEntity<ExamResponse> getExam(@PathVariable("examId") Long examId)
    {
        return ResponseEntity.ok(examService.getExamById(examId));
    }
    @Operation(
            summary = "Get All Exams",
            description = "Returns a paginated list of exams."
    )
    @GetMapping
    public ResponseEntity<Page<ExamSummaryResponse>> getAllExams(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
    {

        return ResponseEntity.ok(examService.getAllExams(page, size));
    }
    @Operation(
            summary = "Publish Exam",
            description = "Publishes an exam so students can start attempting it."
    )
    @PatchMapping("/{examId}/publish")
    public ResponseEntity<PublishedExamResponse> publishExam(@PathVariable Long examId)
    {
        return ResponseEntity.ok(examService.publishedExam(examId));
    }
    @Operation(
            summary = "Delete Exam",
            description = "Deletes an exam."
    )
    @DeleteMapping("/{examId}")
    public ResponseEntity<String> deleteExam(@PathVariable Long examId)
    {
        examService.deleteExamById(examId);
        return ResponseEntity.ok("Exam has been deleted successfully");
    }
    @Operation(
            summary = "Internal Answer Key",
            description = "Returns the answer key for Result Service. Internal API only."
    )
    @GetMapping("/internal/{examId}/answer-key")
    public ExamAnswerKeyResponse getAnswerKey(
            @PathVariable Long examId
    ) {
        return examService.getExamAnswerKey(examId);
    }
}
