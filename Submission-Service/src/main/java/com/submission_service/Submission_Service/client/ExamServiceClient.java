package com.submission_service.Submission_Service.client;

import com.submission_service.Submission_Service.dto.response.ExamResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EXAM-SERVICE")
public interface ExamServiceClient {

    @GetMapping("/api/exams/{examId}")
   ExamResponse getExamById(@PathVariable Long examId);
}
