package com.exam_service.Exam_Service.controller;

import com.exam_service.Exam_Service.dto.internal.ExamAnswerKeyResponse;
import com.exam_service.Exam_Service.dto.request.CreateExamRequest;
import com.exam_service.Exam_Service.dto.response.CreateExamResponse;
import com.exam_service.Exam_Service.dto.response.ExamResponse;
import com.exam_service.Exam_Service.dto.response.ExamSummaryResponse;
import com.exam_service.Exam_Service.dto.response.PublishedExamResponse;
import com.exam_service.Exam_Service.service.impl.ExamServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@RequiredArgsConstructor
public class ExamController {

    private final ExamServiceImpl  examService;

    @PostMapping
    public ResponseEntity<CreateExamResponse> createExam(@RequestBody CreateExamRequest request)
    {
        return ResponseEntity.ok(examService.createExam(request));
    }

    @GetMapping("/{examId}")
    public ResponseEntity<ExamResponse> getExam(@PathVariable("examId") Long examId)
    {
        return ResponseEntity.ok(examService.getExamById(examId));
    }

    @GetMapping
    public ResponseEntity<Page<ExamSummaryResponse>> getAllExams(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size)
    {

        return ResponseEntity.ok(examService.getAllExams(page, size));
    }

    @PatchMapping("/{examId}/publish")
    public ResponseEntity<PublishedExamResponse> publishExam(@PathVariable Long examId)
    {
        return ResponseEntity.ok(examService.publishedExam(examId));
    }

    @DeleteMapping("/{examId}")
    public ResponseEntity<String> deleteExam(@PathVariable Long examId)
    {
        examService.deleteExamById(examId);
        return ResponseEntity.ok("Exam has been deleted successfully");
    }

    @GetMapping("/internal/{examId}/answer-key")
    public ExamAnswerKeyResponse getAnswerKey(
            @PathVariable Long examId
    ) {
        return examService.getExamAnswerKey(examId);
    }
}
